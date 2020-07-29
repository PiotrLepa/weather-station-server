package pl.piotr.weatherstation.weather.domain.converter

import org.springframework.stereotype.Component
import pl.piotr.weatherstation.core.converter.Converter
import pl.piotr.weatherstation.weather.domain.dto.WeatherDto
import pl.piotr.weatherstation.weather.domain.entity.Weather

@Component
class WeatherDtoConverter : Converter<Weather, WeatherDto> {

  override fun convert(from: Weather) = WeatherDto(
      temperature = from.temperature,
      humidity = from.humidity,
      pressure = from.pressure,
      pm1 = from.pm1,
      pm25 = from.pm25,
      pm10 = from.pm10,
      windSpeedMax = from.windSpeedMax,
      windSpeedAvg = from.windSpeedAvg,
      rainGauge = from.rainGauge,
      latitude = from.latitude,
      longitude = from.longitude,
      date = from.creationDate
  )
}
