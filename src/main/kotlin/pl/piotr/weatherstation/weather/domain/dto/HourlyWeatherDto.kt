package pl.piotr.weatherstation.weather.domain.dto

import java.time.LocalDateTime

data class HourlyWeatherDto(
  val temperature: Float,
  val humidity: Float,
  val pressure: Int,
  val pm1: Int,
  val pm25: Int,
  val pm10: Int,
  val rainGauge: Float,
  val windSpeedMax: Float,
  val windSpeedAvg: Float,
  val dateTime: LocalDateTime,
)
