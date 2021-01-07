package pl.piotr.weatherstation.weather.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pl.piotr.weatherstation.core.converter.Converter
import pl.piotr.weatherstation.core.converter.ConverterWithArgs
import pl.piotr.weatherstation.core.notnull.ifNotNull
import pl.piotr.weatherstation.geocode.domain.dto.GeocodedAddressDto
import pl.piotr.weatherstation.geocode.service.GeocodeService
import pl.piotr.weatherstation.notification.service.PushNotificationService
import pl.piotr.weatherstation.weather.domain.converter.WeatherDaysDtoConverter
import pl.piotr.weatherstation.weather.domain.dto.HourlyWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.SaveCachedWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.SaveWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.WeatherDaysDto
import pl.piotr.weatherstation.weather.domain.dto.WeatherDto
import pl.piotr.weatherstation.weather.domain.entity.Address
import pl.piotr.weatherstation.weather.domain.entity.HourlyWeather
import pl.piotr.weatherstation.weather.domain.entity.Weather
import pl.piotr.weatherstation.weather.repository.AddressRepository
import pl.piotr.weatherstation.weather.repository.WeatherRepository
import pl.piotr.weatherstation.weather.service.WeatherService
import pl.piotr.weatherstation.weather.util.TimeAdjuster
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.TimeZone

@Service
class WeatherServiceImpl @Autowired constructor(
  private val weatherRepository: WeatherRepository,
  private val addressRepository: AddressRepository,
  private val pushNotificationService: PushNotificationService,
  private val geocodeService: GeocodeService,
  private val timeAdjuster: TimeAdjuster,
  private val weatherDtoConverter: Converter<Weather, WeatherDto>,
  private val hourlyWeatherDtoConverter: ConverterWithArgs<HourlyWeather, HourlyWeatherDto, LocalDate>,
  private val weatherDaysDtoConverter: WeatherDaysDtoConverter,
  private val saveWeatherEntityConverter: ConverterWithArgs<SaveWeatherDto, Weather, Address?>,
  private val saveCachedWeatherEntityConverter: ConverterWithArgs<SaveCachedWeatherDto, Weather, Address?>,
  private val geocodedAddressDtoToAddressEntityConverter: Converter<GeocodedAddressDto, Address>,
) : WeatherService {

  override fun getCurrentWeather(): WeatherDto =
    weatherRepository.findFirstByOrderByCreationDateDesc()
      .let(weatherDtoConverter::convert)

  override fun getHourlyWeatherForDay(day: LocalDate, timeZone: String): List<HourlyWeatherDto> {
    val zone = TimeZone.getTimeZone(timeZone)
    val startDate = LocalDateTime.of(day, LocalTime.MIDNIGHT)
      .minusHours(timeAdjuster.getHourOffSet(zone).toLong())
    return weatherRepository.getHourlyForDay(
      startDate,
      startDate.plusDays(1),
    ).map {
      val hour = timeAdjuster.adjustHour(it.hourOfDay, zone)
      hourlyWeatherDtoConverter.convert(it.copy(hourOfDay = hour), day)
    }
      .sortedBy { it.dateTime }
  }

  override fun getAvailableDays(): WeatherDaysDto = weatherRepository.getAvailableDays()
    .let(weatherDaysDtoConverter::convert)

  override fun saveWeather(dto: SaveWeatherDto) {
    val address = getAddressForNewWeather(dto.latitude, dto.longitude)
    val weather = saveWeatherEntityConverter.convert(dto, address)
    weatherRepository.save(weather)
  }

  override fun saveCachedWeathers(weathers: List<SaveCachedWeatherDto>) {
    val weathersToSave = weathers.map { dto ->
      val address = getAddressForNewWeather(dto.weather.latitude, dto.weather.longitude)
      saveCachedWeatherEntityConverter.convert(dto, address)
    }
    weatherRepository.saveAll(weathersToSave)
  }

  override fun rainDetected() {
    pushNotificationService.sendRainDetected()
  }

  private fun getAddressForNewWeather(latitude: Double?, longitude: Double?): Address? =
    ifNotNull(latitude, longitude) { lat, long ->
      addressRepository.getClosest(lat, long) ?: geocodeService.reverse(lat, long)
        ?.let(geocodedAddressDtoToAddressEntityConverter::convert)
    }
}
