package pl.piotr.weatherstation.weather.domain.dto

import java.sql.Timestamp

data class WeatherDto(
  val temperature: Double,
  val pm1: Int,
  val pm25: Int,
  val pm10: Int,
  val date: Timestamp
)