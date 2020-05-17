package pl.piotr.weatherstation.weather.domain.converter

import org.springframework.stereotype.Component
import pl.piotr.weatherstation.core.converter.Converter
import pl.piotr.weatherstation.weather.domain.dto.WeatherDto
import pl.piotr.weatherstation.weather.domain.entity.Weather

@Component
class WeatherDtoConverter : Converter<Weather, WeatherDto> {

  override fun convert(from: Weather) = WeatherDto(
      temperature = from.temperature,
      creationDate = from.creationDate
  )
}