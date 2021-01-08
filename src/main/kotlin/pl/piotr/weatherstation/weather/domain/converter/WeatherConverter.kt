package pl.piotr.weatherstation.weather.domain.converter

import org.springframework.stereotype.Component
import pl.piotr.weatherstation.weather.domain.dto.SaveCachedWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.SaveWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.WeatherDto
import pl.piotr.weatherstation.weather.domain.entity.Address
import pl.piotr.weatherstation.weather.domain.entity.Weather
import pl.piotr.weatherstation.weather.util.WeatherAddressFormatter
import java.time.LocalDateTime

@Component
class WeatherConverter(
  private val addressFormatter: WeatherAddressFormatter,
) {

  fun toDto(from: Weather) = WeatherDto(
    temperature = from.temperature,
    humidity = from.humidity,
    pressure = from.pressure,
    pm1 = from.pm1,
    pm25 = from.pm25,
    pm10 = from.pm10,
    windSpeedMax = from.windSpeedMax,
    windSpeedAvg = from.windSpeedAvg,
    rainGauge = from.rainGauge,
    address = from.address?.let { addressFormatter.format(it.city, it.street) },
    dateTime = from.creationDate
  )

  fun toEntity(from: SaveWeatherDto, address: Address?) = Weather(
    temperature = from.temperature,
    humidity = from.humidity,
    pressure = from.pressure,
    pm1 = from.pm1,
    pm25 = from.pm25,
    pm10 = from.pm10,
    windSpeedMax = from.windSpeedMax,
    windSpeedAvg = from.windSpeedAvg,
    rainGauge = from.rainGauge,
    address = address,
    creationDate = LocalDateTime.now()
  )

  fun toEntity(from: SaveCachedWeatherDto, address: Address?) = Weather(
    temperature = from.weather.temperature,
    humidity = from.weather.humidity,
    pressure = from.weather.pressure,
    pm1 = from.weather.pm1,
    pm25 = from.weather.pm25,
    pm10 = from.weather.pm10,
    windSpeedMax = from.weather.windSpeedMax,
    windSpeedAvg = from.weather.windSpeedAvg,
    rainGauge = from.weather.rainGauge,
    address = address,
    creationDate = from.timestamp
  )
}
