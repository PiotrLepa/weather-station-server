package pl.piotr.weatherstation.weather.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pl.piotr.weatherstation.core.converter.Converter
import pl.piotr.weatherstation.weather.domain.dto.WeatherDto
import pl.piotr.weatherstation.weather.domain.entity.Weather
import pl.piotr.weatherstation.weather.repository.WeatherRepository
import pl.piotr.weatherstation.weather.service.WeatherService

@Service
class WeatherServiceImpl @Autowired constructor(
  private val repository: WeatherRepository,
  private val weatherDtoConverter: Converter<Weather, WeatherDto>
) : WeatherService {

  override fun getCurrentWeather(): WeatherDto =
      repository.findFirstByOrderByCreationDateDesc()
          .let(weatherDtoConverter::convert)
}