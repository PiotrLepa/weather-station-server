package pl.piotr.weatherstation.weather.domain.converter

import org.springframework.stereotype.Component
import pl.piotr.weatherstation.address.domain.entity.Address
import pl.piotr.weatherstation.core.converter.ConverterWithArgs
import pl.piotr.weatherstation.weather.domain.dto.SaveCachedWeatherDto
import pl.piotr.weatherstation.weather.domain.entity.Weather

@Component
class SaveCachedWeatherEntityConverter : ConverterWithArgs<SaveCachedWeatherDto, Weather, Address?> {

  override fun convert(from: SaveCachedWeatherDto, args: Address?) = Weather(
      temperature = from.weather.temperature,
      humidity = from.weather.humidity,
      pressure = from.weather.pressure,
      pm1 = from.weather.pm1,
      pm25 = from.weather.pm25,
      pm10 = from.weather.pm10,
      windSpeedMax = from.weather.windSpeedMax,
      windSpeedAvg = from.weather.windSpeedAvg,
      rainGauge = from.weather.rainGauge,
      address = args,
      creationDate = from.timestamp
  )
}
