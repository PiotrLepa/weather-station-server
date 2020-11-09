package pl.piotr.weatherstation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
class WeatherStationServerApplication

fun main(args: Array<String>) {
  runApplication<WeatherStationServerApplication>(*args)
}
