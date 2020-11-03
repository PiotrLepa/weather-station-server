package pl.piotr.weatherstation.weather.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pl.piotr.weatherstation.core.converter.Converter
import pl.piotr.weatherstation.weather.FakeWeather
import pl.piotr.weatherstation.weather.domain.dto.SaveCachedWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.SaveWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.WeatherDto
import pl.piotr.weatherstation.weather.domain.entity.Weather
import pl.piotr.weatherstation.weather.repository.WeatherRepository
import pl.piotr.weatherstation.weather.service.WeatherService
import java.time.LocalDate

@Service
class WeatherServiceImpl @Autowired constructor(
  private val repository: WeatherRepository,
  private val weatherDtoConverter: Converter<Weather, WeatherDto>,
  private val saveWeatherEntityConverter: Converter<SaveWeatherDto, Weather>,
  private val saveCachedWeatherEntityConverter: Converter<SaveCachedWeatherDto, Weather>
) : WeatherService {

  override fun getCurrentWeather(): WeatherDto =
      repository.findFirstByOrderByCreationDateDesc()
          .let(weatherDtoConverter::convert)

  override fun getHourlyWeatherForDay(day: LocalDate): List<WeatherDto> {
    return FakeWeather.getHourlyWeather(day)
  }

  override fun saveWeather(saveWeatherDto: SaveWeatherDto) {
    val weather = saveWeatherEntityConverter.convert(saveWeatherDto)
    repository.save(weather)
  }

  override fun saveCachedWeathers(weathers: List<SaveCachedWeatherDto>) {
    val weathersToSave = weathers.map(saveCachedWeatherEntityConverter::convert)
    repository.saveAll(weathersToSave)
  }
}
