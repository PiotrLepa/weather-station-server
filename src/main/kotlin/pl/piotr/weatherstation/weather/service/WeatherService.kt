package pl.piotr.weatherstation.weather.service

import pl.piotr.weatherstation.weather.domain.dto.SaveCachedWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.SaveWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.WeatherDto
import pl.piotr.weatherstation.weather.domain.entity.HourlyWeather
import java.time.LocalDate

interface WeatherService {

  fun getCurrentWeather(): WeatherDto

  fun getHourlyWeatherForDay(day: LocalDate): List<HourlyWeather>

  fun saveWeather(dto: SaveWeatherDto)

  fun saveCachedWeathers(weathers: List<SaveCachedWeatherDto>)

  fun rainDetected()
}
