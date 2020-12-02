package pl.piotr.weatherstation.weather.domain.entity

import pl.piotr.weatherstation.core.extensions.roundToDecimals
import kotlin.math.roundToInt

data class HourlyWeather(
  val temperature: Float,
  val humidity: Float,
  val pressure: Int,
  val pm1: Int,
  val pm25: Int,
  val pm10: Int,
  val rainGauge: Float,
  val windSpeedMax: Float,
  val windSpeedAvg: Float,
  val hourOfDay: Int,
) {
  constructor(
    temperature: Double,
    humidity: Double,
    pressure: Double,
    pm1: Double,
    pm25: Double,
    pm10: Double,
    rainGauge: Double,
    windSpeedMax: Float,
    windSpeedAvg: Double,
    hourOfDay: Int,
  ) : this(temperature.roundToDecimals(1).toFloat(), humidity.roundToDecimals(1).toFloat(),
      pressure.roundToInt(), pm1.roundToInt(), pm25.roundToInt(), pm10.roundToInt(),
      rainGauge.roundToDecimals(1).toFloat(), windSpeedMax.roundToDecimals(1).toFloat(),
      windSpeedAvg.roundToDecimals(1).toFloat(), hourOfDay)
}
