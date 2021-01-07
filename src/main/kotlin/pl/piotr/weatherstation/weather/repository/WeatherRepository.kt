package pl.piotr.weatherstation.weather.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import pl.piotr.weatherstation.weather.domain.entity.HourlyWeather
import pl.piotr.weatherstation.weather.domain.entity.Weather
import java.time.LocalDate
import java.time.LocalDateTime

@Repository
interface WeatherRepository : JpaRepository<Weather, Long> {

  fun findFirstByOrderByCreationDateDesc(): Weather

  @Query(
    """
      SELECT new pl.piotr.weatherstation.weather.domain.entity.HourlyWeather(
        AVG(w.temperature), AVG(w.humidity), AVG(w.pressure),
        AVG(w.pm1), AVG(w.pm25), AVG(w.pm10),
        AVG(w.rainGauge), AVG(w.windSpeedMax), AVG(w.windSpeedAvg),
        EXTRACT(HOUR FROM w.creationDate) AS hourOfDay
        )
      FROM Weather AS w
      WHERE w.creationDate >= :startDay AND w.creationDate < :endDay
      GROUP BY hourOfDay
    """,
  )
  fun getHourlyForDay(
    @Param("startDay") startDay: LocalDateTime,
    @Param("endDay") endDay: LocalDateTime,
  ): List<HourlyWeather>

  @Query(
    """
      SELECT DISTINCT CAST(w.creationDate AS LocalDate) 
      FROM Weather AS w
      ORDER BY 1
    """,
  )
  fun getAvailableDays(): List<LocalDate>
}
