package pl.piotr.weatherstation.weather.domain.converter

import org.springframework.stereotype.Component
import pl.piotr.weatherstation.weather.domain.dto.WeatherDaysDto
import java.time.LocalDate

@Component
class WeatherDaysConverter {

  fun toDto(from: List<LocalDate>) = WeatherDaysDto(
    days = from
  )
}
