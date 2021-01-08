package pl.piotr.weatherstation.weather.domain.dto

import java.time.LocalDateTime

data class SaveCachedWeatherDto(
  val weather: SaveWeatherDto,
  val timestamp: LocalDateTime
)
