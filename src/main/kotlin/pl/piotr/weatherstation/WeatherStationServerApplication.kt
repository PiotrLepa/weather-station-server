package pl.piotr.weatherstation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WeatherStationServerApplication

fun main(args: Array<String>) {
	runApplication<WeatherStationServerApplication>(*args)
}
