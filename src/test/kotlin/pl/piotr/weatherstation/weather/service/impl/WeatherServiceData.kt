package pl.piotr.weatherstation.weather.service.impl

import pl.piotr.weatherstation.weather.domain.dto.HourlyWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.SaveCachedWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.SaveWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.WeatherDaysDto
import pl.piotr.weatherstation.weather.domain.dto.WeatherDto
import pl.piotr.weatherstation.weather.domain.entity.Address
import pl.piotr.weatherstation.weather.domain.entity.HourlyWeather
import pl.piotr.weatherstation.weather.domain.entity.Weather
import java.time.LocalDate
import java.time.LocalDateTime

fun getWeather(address: Address? = null): Weather = Weather(
  temperature = 22.3f,
  humidity = 80.9f,
  pressure = 981,
  pm1 = 17,
  pm25 = 18,
  pm10 = 22,
  windSpeedMax = 13.1f,
  windSpeedAvg = 7.6f,
  rainGauge = 2.5f,
  address = address,
  creationDate = LocalDateTime.of(2020, 7, 22, 10, 35, 45, 0),
  weatherId = 0L,
)

fun getWeatherDto(): WeatherDto = WeatherDto(
  temperature = 22.3f,
  humidity = 80.9f,
  pressure = 981,
  pm1 = 17,
  pm25 = 18,
  pm10 = 22,
  windSpeedMax = 13.1f,
  windSpeedAvg = 7.6f,
  rainGauge = 2.5f,
  address = null,
  dateTime = LocalDateTime.of(2020, 7, 22, 10, 35, 45, 0),
)

fun getHourlyWeathers(): List<HourlyWeather> = listOf(
  HourlyWeather(
    temperature = 22.3f,
    humidity = 80.9f,
    pressure = 981,
    pm1 = 17,
    pm25 = 18,
    pm10 = 22,
    windSpeedMax = 13.1f,
    windSpeedAvg = 7.6f,
    rainGauge = 2.5f,
    hourOfDay = 0,
  ),
  HourlyWeather(
    temperature = 22.3f,
    humidity = 80.9f,
    pressure = 981,
    pm1 = 17,
    pm25 = 18,
    pm10 = 22,
    windSpeedMax = 13.1f,
    windSpeedAvg = 7.6f,
    rainGauge = 2.5f,
    hourOfDay = 1,
  )
)

fun getHourlyWeathersDto(): List<HourlyWeatherDto> = listOf(
  HourlyWeatherDto(
    temperature = 22.3f,
    humidity = 80.9f,
    pressure = 981,
    pm1 = 17,
    pm25 = 18,
    pm10 = 22,
    windSpeedMax = 13.1f,
    windSpeedAvg = 7.6f,
    rainGauge = 2.5f,
    dateTime = LocalDateTime.of(2020, 7, 12, 0, 0, 0),
  ),
  HourlyWeatherDto(
    temperature = 22.3f,
    humidity = 80.9f,
    pressure = 981,
    pm1 = 17,
    pm25 = 18,
    pm10 = 22,
    windSpeedMax = 13.1f,
    windSpeedAvg = 7.6f,
    rainGauge = 2.5f,
    dateTime = LocalDateTime.of(2020, 7, 12, 1, 0, 0),
  )
)

fun getSaveWeatherDto(
  latitude: Double? = null,
  longitude: Double? = null,
): SaveWeatherDto = SaveWeatherDto(
  temperature = 22.3f,
  humidity = 80.9f,
  pressure = 981,
  pm1 = 17,
  pm25 = 18,
  pm10 = 22,
  windSpeedMax = 13.1f,
  windSpeedAvg = 7.6f,
  rainGauge = 2.5f,
  latitude = latitude,
  longitude = longitude,
)

fun getSaveCachedWeathersDto(
  latitude: Double? = null,
  longitude: Double? = null,
): List<SaveCachedWeatherDto> = listOf(
  SaveCachedWeatherDto(getSaveWeatherDto(latitude, longitude), LocalDateTime.of(2020, 7, 22, 10, 35, 45, 0)),
  SaveCachedWeatherDto(getSaveWeatherDto(latitude, longitude), LocalDateTime.of(2020, 7, 22, 10, 35, 50, 0)),
)

fun getAvailableDays(): List<LocalDate> = listOf(
  LocalDate.of(2020, 7, 12),
  LocalDate.of(2020, 7, 15),
  LocalDate.of(2020, 8, 3),
  LocalDate.of(2020, 8, 22),
  LocalDate.of(2020, 11, 8),
)

fun getWeatherDaysDto(): WeatherDaysDto = WeatherDaysDto(
  days = getAvailableDays()
)
