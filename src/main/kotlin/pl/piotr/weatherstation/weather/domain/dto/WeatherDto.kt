package pl.piotr.weatherstation.weather.domain.dto

import org.hibernate.annotations.CreationTimestamp
import java.sql.Timestamp

data class WeatherDto(
  val temperature: Double,
  @CreationTimestamp
  val creationDate: Timestamp = Timestamp(0)
)