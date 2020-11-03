package pl.piotr.weatherstation.weather

import pl.piotr.weatherstation.weather.domain.dto.WeatherDto
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.random.Random

object FakeWeather {
  fun getHourlyWeather(day: LocalDate): List<WeatherDto> {
    val dateTime = LocalDateTime.of(day, LocalTime.of(0, 0))
    return listOf(
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(1)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(2)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(3)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(4)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(5)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(6)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(7)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(8)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(9)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(10)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(11)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(12)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(13)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(14)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(15)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(16)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(17)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(18)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(19)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(20)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(21)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(22)),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, dateTime.plusHours(23))
    )
  }

  private fun rand(start: Double, end: Double): Float = (Random.nextDouble(start, end) * 10).toInt() / 10.0f

  private fun rand(start: Int, end: Int): Int = Random.nextInt(start, end)
}
