package pl.piotr.weatherstation.weather.domain.converter

import org.springframework.stereotype.Component
import pl.piotr.weatherstation.core.converter.ConverterWithArgs
import pl.piotr.weatherstation.weather.domain.dto.SaveWeatherDto
import pl.piotr.weatherstation.weather.domain.entity.Address
import pl.piotr.weatherstation.weather.domain.entity.Weather
import java.time.LocalDateTime

@Component
class SaveWeatherEntityConverter : ConverterWithArgs<SaveWeatherDto, Weather, Address?> {

  override fun convert(from: SaveWeatherDto, args: Address?) = Weather(
    temperature = from.temperature,
    humidity = from.humidity,
    pressure = from.pressure,
    pm1 = from.pm1,
    pm25 = from.pm25,
    pm10 = from.pm10,
    windSpeedMax = from.windSpeedMax,
    windSpeedAvg = from.windSpeedAvg,
    rainGauge = from.rainGauge,
    address = args,
    creationDate = LocalDateTime.now()
  )
}
