package pl.piotr.weatherstation.weather.domain.dto

data class SaveWeatherDto(
  val temperature: Double,
  val humidity: Double,
  val pressure: Int,
  val pm1: Int,
  val pm25: Int,
  val pm10: Int,
  val windSpeedMax: Double,
  val windSpeedAvg: Double,
  val rainGauge: Double,
  val latitude: Double?,
  val longitude: Double?
)
