package pl.piotr.weatherstation.weather.domain.dto

import java.sql.Timestamp

data class WeatherDto(
  val temperature: Double,
  val humidity: Double,
  val pm1: Int,
  val pm25: Int,
  val pm10: Int,
  val windSpeedMax: Double,
  val windSpeedAvg: Double,
  val rainGauge: Double,
  val date: Timestamp
)