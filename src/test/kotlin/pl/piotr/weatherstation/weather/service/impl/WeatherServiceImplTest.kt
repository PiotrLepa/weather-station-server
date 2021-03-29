package pl.piotr.weatherstation.weather.service.impl

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.piotr.weatherstation.geocode.domain.converter.GeocodeAddressConverter
import pl.piotr.weatherstation.geocode.service.GeocodeService
import pl.piotr.weatherstation.geocode.service.impl.getAddress
import pl.piotr.weatherstation.geocode.service.impl.getGeocodedAddressDto
import pl.piotr.weatherstation.notification.service.PushNotificationService
import pl.piotr.weatherstation.weather.domain.converter.HourlyWeatherConverter
import pl.piotr.weatherstation.weather.domain.converter.WeatherConverter
import pl.piotr.weatherstation.weather.domain.converter.WeatherDaysConverter
import pl.piotr.weatherstation.weather.domain.dto.SaveCachedWeatherDto
import pl.piotr.weatherstation.weather.repository.AddressRepository
import pl.piotr.weatherstation.weather.repository.WeatherRepository
import pl.piotr.weatherstation.weather.util.TimeAdjuster

@ExtendWith(MockKExtension::class)
class WeatherServiceImplTest {

  private val weatherRepository: WeatherRepository = mockk()
  private val addressRepository: AddressRepository = mockk()
  private val pushNotificationService: PushNotificationService = mockk()
  private val geocodeService: GeocodeService = mockk()
  private val timeAdjuster: TimeAdjuster = mockk()
  private val weatherConverter: WeatherConverter = mockk()
  private val hourlyWeatherConverter: HourlyWeatherConverter = mockk()
  private val weatherDaysConverter: WeatherDaysConverter = mockk()
  private val geocodeAddressConverter: GeocodeAddressConverter = mockk()

  @InjectMockKs
  lateinit var weatherService: WeatherServiceImpl

  @Test
  fun `current weather should return dto with correct data`() {
    // given
    val entity = getWeather()
    val dto = getWeatherDto()

    every { weatherRepository.findFirstByOrderByCreationDateDesc() } returns entity
    every { weatherConverter.toDto(entity) } returns dto

    // when
    val resultDto = weatherService.getCurrentWeather()

    // then
    assert(resultDto == dto)
    verify(exactly = 1) { weatherRepository.findFirstByOrderByCreationDateDesc() }
    verify(exactly = 1) { weatherConverter.toDto(entity) }
  }

  @Test
  fun `hourly weather should return dto with correct data`() {
    // given
    val entity = getHourlyWeathers()
    val dto = getHourlyWeathersDto()
    val day = dto.first().dateTime.toLocalDate()
    val zone = "UTC"

    every { weatherRepository.getHourlyForDay(any(), any()) } returns entity
    every { hourlyWeatherConverter.toDto(any(), any()) } returnsMany dto
    every { timeAdjuster.adjustHour(any(), any()) } returnsMany entity.map { it.hourOfDay }
    every { timeAdjuster.getHoursOffSet(any()) } returnsMany entity.map { it.hourOfDay }

    // when
    val resultDto = weatherService.getHourlyWeatherForDay(day, zone)

    // then
    assert(resultDto == dto)
    verify(exactly = 1) { weatherRepository.getHourlyForDay(any(), any()) }
    verify(exactly = entity.size) { hourlyWeatherConverter.toDto(any(), any()) }
  }

  @Test
  fun `available days should return dto with correct data`() {
    // given
    val entity = getAvailableDays()
    val dto = getWeatherDaysDto()

    every { weatherRepository.getAvailableDays() } returns entity
    every { weatherDaysConverter.toDto(entity) } returns dto

    // when
    val resultDto = weatherService.getAvailableDays()

    // then
    assert(resultDto == dto)
    verify(exactly = 1) { weatherRepository.getAvailableDays() }
    verify(exactly = 1) { weatherDaysConverter.toDto(entity) }
  }

  @Test
  fun `should convert weather data and save`() {
    // given
    val address = getAddress()
    val dto = getSaveWeatherDto(latitude = address.latitude, longitude = address.longitude)
    val entity = getWeather(address = address)

    every { weatherRepository.save(entity) } returns entity
    every { addressRepository.getClosest(address.latitude, address.longitude) } returns address
    every { weatherConverter.toEntity(dto, address) } returns entity

    // when
    weatherService.saveWeather(dto)

    // then
    verify(exactly = 1) { weatherRepository.save(entity) }
    verify(exactly = 1) { weatherConverter.toEntity(dto, address) }
  }

  @Test
  fun `should get address from repository if nearby address is saved`() {
    // given
    val address = getAddress()
    val dto = getSaveWeatherDto(latitude = address.latitude, longitude = address.longitude)
    val entity = getWeather(address = address)

    every { weatherRepository.save(entity) } returns entity
    every { addressRepository.getClosest(address.latitude, address.longitude) } returns address
    every { weatherConverter.toEntity(dto, address) } returns entity

    // when
    weatherService.saveWeather(dto)

    // then
    verify(exactly = 1) { addressRepository.getClosest(address.latitude, address.longitude) }
  }

  @Test
  fun `should geocode address if weather to save has coordinates and there is no nearby address`() {
    // given
    val address = getAddress()
    val geocodedAddressDto = getGeocodedAddressDto()
    val dto = getSaveWeatherDto(latitude = address.latitude, longitude = address.longitude)
    val entity = getWeather(address = address)

    every { geocodeService.reverse(address.latitude, address.longitude) } returns geocodedAddressDto
    every { weatherRepository.save(entity) } returns entity
    every { addressRepository.getClosest(address.latitude, address.longitude) } returns null
    every { weatherConverter.toEntity(dto, address) } returns entity
    every { geocodeAddressConverter.toEntity(geocodedAddressDto) } returns address

    // when
    weatherService.saveWeather(dto)

    // then
    verify(exactly = 1) { addressRepository.getClosest(address.latitude, address.longitude) }
    verify(exactly = 1) { geocodeService.reverse(address.latitude, address.longitude) }
    verify(exactly = 1) { geocodeAddressConverter.toEntity(geocodedAddressDto) }
  }

  @Test
  fun `should not call address repository and geocode service if weather to save has no coordinates`() {
    // given
    val dto = getSaveWeatherDto()
    val entity = getWeather()

    every { weatherRepository.save(entity) } returns entity
    every { weatherConverter.toEntity(dto, null) } returns entity

    // when
    weatherService.saveWeather(dto)

    // then
    verify(exactly = 0) { addressRepository.getClosest(any(), any()) }
    verify(exactly = 0) { geocodeService.reverse(any(), any()) }
    verify(exactly = 0) { geocodeAddressConverter.toEntity(any()) }
  }

  @Test
  fun `should convert all of cached weathers data and save`() {
    // given
    val address = getAddress()
    val dto = getSaveCachedWeathersDto(latitude = address.latitude, longitude = address.longitude)
    val entity = listOf(getWeather(address = address), getWeather(address = address))

    every { weatherRepository.saveAll(entity) } returns entity
    every { addressRepository.getClosest(address.latitude, address.longitude) } returns address
    every { weatherConverter.toEntity(any<SaveCachedWeatherDto>(), address) } returnsMany entity

    // when
    weatherService.saveCachedWeathers(dto)

    // then
    verify(exactly = 1) { weatherRepository.saveAll(entity) }
    verify(exactly = dto.size) { weatherConverter.toEntity(any<SaveCachedWeatherDto>(), address) }
  }

  @Test
  fun `should get address from repository if cached weathers data to save have coordinates and nearby address is saved`() {
    // given
    val address = getAddress()
    val dto = getSaveCachedWeathersDto(latitude = address.latitude, longitude = address.longitude)
    val entity = listOf(getWeather(address = address), getWeather(address = address))

    every { weatherRepository.saveAll(entity) } returns entity
    every { addressRepository.getClosest(address.latitude, address.longitude) } returns address
    every { weatherConverter.toEntity(any<SaveCachedWeatherDto>(), address) } returnsMany entity

    // when
    weatherService.saveCachedWeathers(dto)

    // then
    verify(exactly = dto.size) { addressRepository.getClosest(address.latitude, address.longitude) }
  }

  @Test
  fun `should geocode addresses if cached weathers data to save have coordinates and there is no nearby address`() {
    // given
    val address = getAddress()
    val geocodedAddressDto = getGeocodedAddressDto()
    val dto = getSaveCachedWeathersDto(latitude = address.latitude, longitude = address.longitude)
    val entity = listOf(getWeather(address = address), getWeather(address = address))

    every { geocodeService.reverse(address.latitude, address.longitude) } returns geocodedAddressDto
    every { weatherRepository.saveAll(entity) } returns entity
    every { addressRepository.getClosest(address.latitude, address.longitude) } returns null
    every { weatherConverter.toEntity(any<SaveCachedWeatherDto>(), address) } returnsMany entity
    every { geocodeAddressConverter.toEntity(geocodedAddressDto) } returns address

    // when
    weatherService.saveCachedWeathers(dto)

    // then
    verify(exactly = dto.size) { addressRepository.getClosest(address.latitude, address.longitude) }
    verify(exactly = dto.size) { geocodeService.reverse(address.latitude, address.longitude) }
    verify(exactly = dto.size) { geocodeAddressConverter.toEntity(geocodedAddressDto) }
  }

  @Test
  fun `should not call address repository and geocode service if cached weathers data to save have no coordinates`() {
    // given
    val dto = getSaveCachedWeathersDto()
    val entity = listOf(getWeather(), getWeather())

    every { weatherRepository.saveAll(entity) } returns entity
    every { weatherConverter.toEntity(any<SaveCachedWeatherDto>(), null) } returnsMany entity

    // when
    weatherService.saveCachedWeathers(dto)

    // then
    verify(exactly = 0) { addressRepository.getClosest(any(), any()) }
    verify(exactly = 0) { geocodeService.reverse(any(), any()) }
    verify(exactly = 0) { geocodeAddressConverter.toEntity(any()) }
  }

  @Test
  fun `should send push notification on rain detected`() {
    // given
    every { pushNotificationService.sendRainDetected() } returns Unit

    // when
    pushNotificationService.sendRainDetected()

    // then
    verify(exactly = 1) { pushNotificationService.sendRainDetected() }
  }

}
