package pl.piotr.weatherstation.weather.rest

import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import pl.piotr.weatherstation.weather.domain.dto.HourlyWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.SaveCachedWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.SaveWeatherDto
import pl.piotr.weatherstation.weather.domain.dto.WeatherDaysDto
import pl.piotr.weatherstation.weather.domain.dto.WeatherDto
import pl.piotr.weatherstation.weather.service.WeatherService
import java.time.LocalDate

@RestController
@RequestMapping("/api/weather")
class WeatherController @Autowired constructor(
  private val weatherService: WeatherService
) {

  @GetMapping("")
  @ApiOperation(value = "Get recently collected weather data")
  fun getCurrentWeather(): ResponseEntity<WeatherDto> {
    val weather = weatherService.getCurrentWeather()
    return ResponseEntity(weather, HttpStatus.OK)
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  @ApiOperation(value = "Save collected weather data")
  fun saveWeather(@RequestBody weather: SaveWeatherDto) {
    weatherService.saveWeather(weather)
  }

  @GetMapping("/days")
  @ApiOperation(value = "Get days for which weather data exists.")
  fun getAvailableDays(): ResponseEntity<WeatherDaysDto> {
    val days = weatherService.getAvailableDays()
    return ResponseEntity(days, HttpStatus.OK)
  }

  @GetMapping("/hourly")
  @ApiOperation(value = "Get weather data for a specific day in hourly format")
  fun getHourlyWeatherForDay(
    @RequestParam("day") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) day: LocalDate,
    @RequestParam("timeZone", defaultValue = "UTC", required = false) timeZone: String,
  ): ResponseEntity<List<HourlyWeatherDto>> {
    val weather = weatherService.getHourlyWeatherForDay(day, timeZone)
    return ResponseEntity(weather, HttpStatus.OK)
  }

  @PostMapping("/cached")
  @ResponseStatus(HttpStatus.CREATED)
  @ApiOperation(value = "Save a list of weathers data collected")
  fun saveCachedWeather(@RequestBody weathers: List<SaveCachedWeatherDto>) {
    weatherService.saveCachedWeathers(weathers)
  }

  @PostMapping("/rain-detected")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @ApiOperation(value = "Send notification to app when rain is detected")
  fun rainDetected() {
    weatherService.rainDetected()
  }

}
