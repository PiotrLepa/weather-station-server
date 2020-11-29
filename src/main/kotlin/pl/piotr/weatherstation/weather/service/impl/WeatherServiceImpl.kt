package pl.piotr.weatherstation.weather.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pl.piotr.weatherstation.core.converter.Converter
import pl.piotr.weatherstation.core.converter.ConverterWithArgs
import pl.piotr.weatherstation.core.notnull.ifNotNull
import pl.piotr.weatherstation.geocode.domain.dto.GeocodedAddressDto
import pl.piotr.weatherstation.geocode.service.GeocodeService
import pl.piotr.weatherstation.notification.PushNotificationService
import pl.piotr.weatherstation.weather.FakeWeather
import pl.piotr.weatherstation.weather.domain.dto.SaveCachedWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.SaveWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.WeatherDto
import pl.piotr.weatherstation.weather.domain.entity.Address
import pl.piotr.weatherstation.weather.domain.entity.Weather
import pl.piotr.weatherstation.weather.repository.AddressRepository
import pl.piotr.weatherstation.weather.repository.WeatherRepository
import pl.piotr.weatherstation.weather.service.WeatherService
import java.time.LocalDate

@Service
class WeatherServiceImpl @Autowired constructor(
  private val weatherRepository: WeatherRepository,
  private val addressRepository: AddressRepository,
  private val pushNotificationService: PushNotificationService,
  private val geocodeService: GeocodeService,
  private val weatherDtoConverter: Converter<Weather, WeatherDto>,
  private val saveWeatherEntityConverter: ConverterWithArgs<SaveWeatherDto, Weather, Address?>,
  private val saveCachedWeatherEntityConverter: ConverterWithArgs<SaveCachedWeatherDto, Weather, Address?>,
  private val geocodedAddressDtoToAddressEntityConverter: Converter<GeocodedAddressDto, Address>,
) : WeatherService {

  override fun getCurrentWeather(): WeatherDto =
      weatherRepository.findFirstByOrderByCreationDateDesc()
          .let(weatherDtoConverter::convert)

  override fun getHourlyWeatherForDay(day: LocalDate): List<WeatherDto> {
    return FakeWeather.getHourlyWeather(day)
  }

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
