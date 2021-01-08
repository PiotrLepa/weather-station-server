package pl.piotr.weatherstation.weather.domain.converter

import org.springframework.stereotype.Component
import pl.piotr.weatherstation.weather.domain.dto.HourlyWeatherDto
import pl.piotr.weatherstation.weather.domain.entity.HourlyWeather
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@Component
class HourlyWeatherConverter {

  fun toDto(from: HourlyWeather, date: LocalDate) = HourlyWeatherDto(
    temperature = from.temperature,
    humidity = from.humidity,
    pressure = from.pressure,
    pm1 = from.pm1,
    pm25 = from.pm25,
    pm10 = from.pm10,
    windSpeedMax = from.windSpeedMax,
    windSpeedAvg = from.windSpeedAvg,
    rainGauge = from.rainGauge,
    dateTime = LocalDateTime.of(date, LocalTime.of(from.hourOfDay, 0))
  )

}
