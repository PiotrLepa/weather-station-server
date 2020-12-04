package pl.piotr.weatherstation.weather.domain.converter

import org.springframework.stereotype.Component
import pl.piotr.weatherstation.core.converter.Converter
import pl.piotr.weatherstation.weather.domain.dto.WeatherDaysDto
import java.time.LocalDate

@Component
class WeatherDaysDtoConverter : Converter<List<LocalDate>, WeatherDaysDto> {

  override fun convert(from: List<LocalDate>) = WeatherDaysDto(
    days = from
  )
}
