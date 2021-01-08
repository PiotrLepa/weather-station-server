package pl.piotr.weatherstation.weather.service.impl

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.piotr.weatherstation.core.converter.Converter
import pl.piotr.weatherstation.core.converter.ConverterWithArgs
import pl.piotr.weatherstation.geocode.domain.dto.GeocodedAddressDto
import pl.piotr.weatherstation.geocode.service.GeocodeService
import pl.piotr.weatherstation.geocode.service.impl.getAddress
import pl.piotr.weatherstation.geocode.service.impl.getGeocodedAddressDto
import pl.piotr.weatherstation.notification.service.PushNotificationService
import pl.piotr.weatherstation.weather.domain.converter.WeatherDaysDtoConverter
import pl.piotr.weatherstation.weather.domain.dto.HourlyWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.SaveCachedWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.SaveWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.WeatherDto
import pl.piotr.weatherstation.weather.domain.entity.Address
import pl.piotr.weatherstation.weather.domain.entity.HourlyWeather
import pl.piotr.weatherstation.weather.domain.entity.Weather
import pl.piotr.weatherstation.weather.repository.AddressRepository
import pl.piotr.weatherstation.weather.repository.WeatherRepository
import pl.piotr.weatherstation.weather.util.TimeAdjuster
import java.time.LocalDate

@ExtendWith(MockKExtension::class)
class WeatherServiceImplTest {

  private val weatherRepository: WeatherRepository = mockk()
  private val addressRepository: AddressRepository = mockk()
  private val pushNotificationService: PushNotificationService = mockk()
  private val geocodeService: GeocodeService = mockk()
  private val timeAdjuster: TimeAdjuster = mockk()
  private val weatherDtoConverter: Converter<Weather, WeatherDto> = mockk()
  private val hourlyWeatherDtoConverter: ConverterWithArgs<HourlyWeather, HourlyWeatherDto, LocalDate> = mockk()
  private val weatherDaysDtoConverter: WeatherDaysDtoConverter = mockk()
  private val saveWeatherEntityConverter: ConverterWithArgs<SaveWeatherDto, Weather, Address?> = mockk()
  private val saveCachedWeatherEntityConverter: ConverterWithArgs<SaveCachedWeatherDto, Weather, Address?> = mockk()
  private val geocodedAddressDtoToAddressEntityConverter: Converter<GeocodedAddressDto, Address> = mockk()

  @InjectMockKs
  lateinit var weatherService: WeatherServiceImpl

  @Test
  fun `current weather should return dto with correct data`() {
    // given
    val entity = getWeather()
    val dto = getWeatherDto()

    every { weatherRepository.findFirstByOrderByCreationDateDesc() } returns entity
    every { weatherDtoConverter.convert(entity) } returns dto

    // when
    val resultDto = weatherService.getCurrentWeather()

    // then
    assert(resultDto == dto)
    verify(exactly = 1) { weatherRepository.findFirstByOrderByCreationDateDesc() }
    verify(exactly = 1) { weatherDtoConverter.convert(entity) }
  }

  @Test
  fun `hourly weather should return dto with correct data`() {
    // given
    val entity = getHourlyWeathers()
    val dto = getHourlyWeathersDto()
    val day = dto.first().dateTime.toLocalDate()
    val zone = "UTC"

    every { weatherRepository.getHourlyForDay(any(), any()) } returns entity
    every { hourlyWeatherDtoConverter.convert(any(), any()) } returnsMany dto
    every { timeAdjuster.adjustHour(any(), any()) } returnsMany entity.map { it.hourOfDay }
    every { timeAdjuster.getHourOffSet(any()) } returnsMany entity.map { it.hourOfDay }

    // when
    val resultDto = weatherService.getHourlyWeatherForDay(day, zone)

    // then
    assert(resultDto == dto)
    verify(exactly = 1) { weatherRepository.getHourlyForDay(any(), any()) }
    verify(exactly = entity.size) { hourlyWeatherDtoConverter.convert(any(), any()) }
  }

  @Test
  fun `available days should return dto with correct data`() {
    // given
    val entity = getAvailableDays()
    val dto = getWeatherDaysDto()

    every { weatherRepository.getAvailableDays() } returns entity
    every { weatherDaysDtoConverter.convert(entity) } returns dto

    // when
    val resultDto = weatherService.getAvailableDays()

    // then
    assert(resultDto == dto)
    verify(exactly = 1) { weatherRepository.getAvailableDays() }
    verify(exactly = 1) { weatherDaysDtoConverter.convert(entity) }
  }

  @Test
  fun `save weather should convert correct dto to entity and call repository`() {
    // given
    val address = getAddress()
    val dto = getSaveWeatherDto(latitude = address.latitude, longitude = address.longitude)
    val entity = getWeather(address = address)

    every { weatherRepository.save(entity) } returns entity
    every { addressRepository.getClosest(address.latitude, address.longitude) } returns address
    every { saveWeatherEntityConverter.convert(dto, address) } returns entity

    // when
    weatherService.saveWeather(dto)

    // then
    verify(exactly = 1) { weatherRepository.save(entity) }
    verify(exactly = 1) { saveWeatherEntityConverter.convert(dto, address) }
  }

  @Test
  fun `save weather with coordinates should get address from repository if nearby address is saved`() {
    // given
    val address = getAddress()
    val dto = getSaveWeatherDto(latitude = address.latitude, longitude = address.longitude)
    val entity = getWeather(address = address)

    every { weatherRepository.save(entity) } returns entity
    every { addressRepository.getClosest(address.latitude, address.longitude) } returns address
    every { saveWeatherEntityConverter.convert(dto, address) } returns entity

    // when
    weatherService.saveWeather(dto)

    // then
    verify(exactly = 1) { addressRepository.getClosest(address.latitude, address.longitude) }
  }

  @Test
  fun `save weather with coordinates should get geocode address if there is no nearby address`() {
    // given
    val address = getAddress()
    val geocodedAddressDto = getGeocodedAddressDto()
    val dto = getSaveWeatherDto(latitude = address.latitude, longitude = address.longitude)
    val entity = getWeather(address = address)

    every { geocodeService.reverse(address.latitude, address.longitude) } returns geocodedAddressDto
    every { weatherRepository.save(entity) } returns entity
    every { addressRepository.getClosest(address.latitude, address.longitude) } returns null
    every { saveWeatherEntityConverter.convert(dto, address) } returns entity
    every { geocodedAddressDtoToAddressEntityConverter.convert(geocodedAddressDto) } returns address

    // when
    weatherService.saveWeather(dto)

    // then
    verify(exactly = 1) { addressRepository.getClosest(address.latitude, address.longitude) }
    verify(exactly = 1) { geocodeService.reverse(address.latitude, address.longitude) }
    verify(exactly = 1) { geocodedAddressDtoToAddressEntityConverter.convert(geocodedAddressDto) }
  }

  @Test
  fun `save weather without coordinates should not call address repository and geocode service`() {
    // given
    val dto = getSaveWeatherDto()
    val entity = getWeather()

    every { weatherRepository.save(entity) } returns entity
    every { saveWeatherEntityConverter.convert(dto, null) } returns entity

    // when
    weatherService.saveWeather(dto)

    // then
    verify(exactly = 0) { addressRepository.getClosest(any(), any()) }
    verify(exactly = 0) { geocodeService.reverse(any(), any()) }
    verify(exactly = 0) { geocodedAddressDtoToAddressEntityConverter.convert(any()) }
  }

  @Test
  fun `save cached weathers should convert correct dto to entity and call repository`() {
    // given
    val address = getAddress()
    val dto = getSaveCachedWeathersDto(latitude = address.latitude, longitude = address.longitude)
    val entity = listOf(getWeather(address = address), getWeather(address = address))

    every { weatherRepository.saveAll(entity) } returns entity
    every { addressRepository.getClosest(address.latitude, address.longitude) } returns address
    every { saveCachedWeatherEntityConverter.convert(any(), address) } returnsMany entity

    // when
    weatherService.saveCachedWeathers(dto)

    // then
    verify(exactly = 1) { weatherRepository.saveAll(entity) }
    verify(exactly = dto.size) { saveCachedWeatherEntityConverter.convert(any(), address) }
  }

  @Test
  fun `save cached weathers with coordinates should get address from repository if nearby address is saved`() {
    // given
    val address = getAddress()
    val dto = getSaveCachedWeathersDto(latitude = address.latitude, longitude = address.longitude)
    val entity = listOf(getWeather(address = address), getWeather(address = address))

    every { weatherRepository.saveAll(entity) } returns entity
    every { addressRepository.getClosest(address.latitude, address.longitude) } returns address
    every { saveCachedWeatherEntityConverter.convert(any(), address) } returnsMany entity

    // when
    weatherService.saveCachedWeathers(dto)

    // then
    verify(exactly = dto.size) { addressRepository.getClosest(address.latitude, address.longitude) }
  }

  @Test
  fun `save cached weathers with coordinates should get geocode address if there is no nearby address`() {
    // given
    val address = getAddress()
    val geocodedAddressDto = getGeocodedAddressDto()
    val dto = getSaveCachedWeathersDto(latitude = address.latitude, longitude = address.longitude)
    val entity = listOf(getWeather(address = address), getWeather(address = address))

    every { geocodeService.reverse(address.latitude, address.longitude) } returns geocodedAddressDto
    every { weatherRepository.saveAll(entity) } returns entity
    every { addressRepository.getClosest(address.latitude, address.longitude) } returns null
    every { saveCachedWeatherEntityConverter.convert(any(), address) } returnsMany entity
    every { geocodedAddressDtoToAddressEntityConverter.convert(geocodedAddressDto) } returns address

    // when
    weatherService.saveCachedWeathers(dto)

    // then
    verify(exactly = dto.size) { addressRepository.getClosest(address.latitude, address.longitude) }
    verify(exactly = dto.size) { geocodeService.reverse(address.latitude, address.longitude) }
    verify(exactly = dto.size) { geocodedAddressDtoToAddressEntityConverter.convert(geocodedAddressDto) }
  }

  @Test
  fun `save cached weathers without coordinates should not call address repository and geocode service`() {
    // given
    val dto = getSaveCachedWeathersDto()
    val entity = listOf(getWeather(), getWeather())

    every { weatherRepository.saveAll(entity) } returns entity
    every { saveCachedWeatherEntityConverter.convert(any(), null) } returnsMany entity

    // when
    weatherService.saveCachedWeathers(dto)

    // then
    verify(exactly = 0) { addressRepository.getClosest(any(), any()) }
    verify(exactly = 0) { geocodeService.reverse(any(), any()) }
    verify(exactly = 0) { geocodedAddressDtoToAddressEntityConverter.convert(any()) }
  }

  @Test
  fun `send push notification on rain detected`() {
    // given
    every { pushNotificationService.sendRainDetected() } returns Unit

    // when
    pushNotificationService.sendRainDetected()

    // then
    verify(exactly = 1) { pushNotificationService.sendRainDetected() }
  }

}
