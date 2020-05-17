package pl.piotr.weatherstation.weather.service

import pl.piotr.weatherstation.weather.domain.dto.SaveWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.WeatherDto

interface WeatherService {

  fun getCurrentWeather(): WeatherDto

  fun saveWeather(saveWeatherDto: SaveWeatherDto)
}