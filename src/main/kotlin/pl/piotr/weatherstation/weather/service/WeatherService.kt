package pl.piotr.weatherstation.weather.service

import pl.piotr.weatherstation.weather.domain.dto.HourlyWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.SaveCachedWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.SaveWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.WeatherDaysDto
import pl.piotr.weatherstation.weather.domain.dto.WeatherDto
import java.time.LocalDate

interface WeatherService {

  fun getCurrentWeather(): WeatherDto

  fun getHourlyWeatherForDay(day: LocalDate, timeZone: String): List<HourlyWeatherDto>

  fun getAvailableDays(): WeatherDaysDto

  fun saveWeather(dto: SaveWeatherDto)

  fun saveCachedWeathers(weathers: List<SaveCachedWeatherDto>)

  fun rainDetected()
}
