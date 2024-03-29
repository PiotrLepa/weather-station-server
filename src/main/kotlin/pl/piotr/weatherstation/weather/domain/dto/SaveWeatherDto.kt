package pl.piotr.weatherstation.weather.domain.dto

data class SaveWeatherDto(
  val temperature: Float,
  val humidity: Float,
  val pressure: Int,
  val pm1: Int,
  val pm25: Int,
  val pm10: Int,
  val windSpeedMax: Float,
  val windSpeedAvg: Float,
  val rainGauge: Float,
  val latitude: Double?,
  val longitude: Double?
)
