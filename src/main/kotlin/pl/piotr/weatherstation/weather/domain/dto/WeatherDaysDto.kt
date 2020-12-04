package pl.piotr.weatherstation.weather.domain.dto

import java.time.LocalDate

data class WeatherDaysDto(
  val dates: List<LocalDate>
)
