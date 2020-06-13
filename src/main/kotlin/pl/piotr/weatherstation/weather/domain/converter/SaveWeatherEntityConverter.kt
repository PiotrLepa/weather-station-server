package pl.piotr.weatherstation.weather.domain.converter

import org.springframework.stereotype.Component
import pl.piotr.weatherstation.core.converter.Converter
import pl.piotr.weatherstation.weather.domain.dto.SaveWeatherDto
import pl.piotr.weatherstation.weather.domain.entity.Weather

@Component
class SaveWeatherEntityConverter : Converter<SaveWeatherDto, Weather> {

  override fun convert(from: SaveWeatherDto) = Weather(
      temperature = from.temperature,
      humidity = from.humidity,
      pm1 = from.pm1,
      pm25 = from.pm25,
      pm10 = from.pm10,
      windSpeedMax = from.windSpeedMax,
      windSpeedAvg = from.windSpeedAvg,
      rainGauge = from.rainGauge
  )
}