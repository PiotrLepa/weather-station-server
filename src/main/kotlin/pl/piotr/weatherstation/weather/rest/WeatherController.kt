package pl.piotr.weatherstation.weather.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import pl.piotr.weatherstation.weather.domain.dto.SaveCachedWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.SaveWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.WeatherDto
import pl.piotr.weatherstation.weather.service.WeatherService
import java.time.LocalDate

@RestController
@RequestMapping("/api/weather")
class WeatherController @Autowired constructor(
  private val weatherService: WeatherService
) {

  @GetMapping("")
  fun getCurrentWeather(): ResponseEntity<WeatherDto> {
    val weather = weatherService.getCurrentWeather()
    return ResponseEntity(weather, HttpStatus.OK)
  }

  @PostMapping("")
  fun saveWeather(@RequestBody weatherToSave: SaveWeatherDto): ResponseEntity<Unit> {
    weatherService.saveWeather(weatherToSave)
    return ResponseEntity(HttpStatus.CREATED)
  }

  @GetMapping("/hourly")
  fun getHourlyWeatherForDay(
    @RequestParam("day") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) day: LocalDate
  ): ResponseEntity<List<WeatherDto>> {
    val weather = weatherService.getHourlyWeatherForDay(day)
    return ResponseEntity(weather, HttpStatus.OK)
  }

  @PostMapping("/cached")
  fun saveCachedWeather(@RequestBody weathersToSave: List<SaveCachedWeatherDto>): ResponseEntity<Unit> {
    weatherService.saveCachedWeathers(weathersToSave)
    return ResponseEntity(HttpStatus.CREATED)
  }

  @PostMapping("/rain-detected")
  fun rainDetected(): ResponseEntity<Unit> {
    weatherService.rainDetected()
    return ResponseEntity(HttpStatus.OK)
  }
}
