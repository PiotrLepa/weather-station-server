package pl.piotr.weatherstation.weather.domain.converter

import org.springframework.stereotype.Component
import pl.piotr.weatherstation.core.converter.Converter
import pl.piotr.weatherstation.weather.domain.dto.SaveCachedWeatherDto
import pl.piotr.weatherstation.weather.domain.entity.Weather

@Component
class SaveCachedWeatherEntityConverter : Converter<SaveCachedWeatherDto, Weather> {

  override fun convert(from: SaveCachedWeatherDto) = Weather(
      temperature = from.weather.temperature,
      humidity = from.weather.humidity,
      pressure = from.weather.pressure,
      pm1 = from.weather.pm1,
      pm25 = from.weather.pm25,
      pm10 = from.weather.pm10,
      windSpeedMax = from.weather.windSpeedMax,
      windSpeedAvg = from.weather.windSpeedAvg,
      rainGauge = from.weather.rainGauge,
      latitude = from.weather.latitude,
      longitude = from.weather.longitude,
      creationDate = from.timestamp
  )
}
