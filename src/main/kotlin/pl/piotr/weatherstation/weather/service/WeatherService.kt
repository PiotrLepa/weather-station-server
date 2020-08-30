package pl.piotr.weatherstation.weather.service

import pl.piotr.weatherstation.weather.domain.dto.SaveWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.WeatherDto
import java.time.LocalDate

interface WeatherService {

  fun getCurrentWeather(): WeatherDto

  fun getHourlyWeatherForDay(day: LocalDate): List<WeatherDto>

  fun saveWeather(saveWeatherDto: SaveWeatherDto)
}
