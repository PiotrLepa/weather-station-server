package pl.piotr.weatherstation.weather

import pl.piotr.weatherstation.weather.domain.dto.WeatherDto
import java.sql.Timestamp
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneOffset
import kotlin.random.Random

object FakeWeather {
  fun getHourlyWeather(day: LocalDate): List<WeatherDto> {
    val dateTime = LocalDateTime.of(day, LocalTime.of(0, 0))
    return listOf(
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(1).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(2).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(3).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(4).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(5).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(6).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(7).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(8).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(9).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(10).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(11).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(12).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(13).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(14).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(15).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(16).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(17).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(18).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(19).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(20).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(21).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(22).toInstant(ZoneOffset.UTC).toEpochMilli())),
        WeatherDto(rand(15.0, 32.0), rand(35.0, 75.0), rand(950, 1010), rand(10, 50), rand(10, 50), rand(10, 50), rand(10.0, 70.0),
            rand(1.0, 10.0), rand(0.0, 10.0), null, null, Timestamp(dateTime.plusHours(23).toInstant(ZoneOffset.UTC).toEpochMilli()))
    )
  }
  
  private fun rand(start: Double, end: Double): Float = (Random.nextDouble(start, end) * 10).toInt() / 10.0f

  private fun rand(start: Int, end: Int): Int = Random.nextInt(start, end)
}
