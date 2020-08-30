package pl.piotr.weatherstation.weather.domain.entity

import org.hibernate.annotations.CreationTimestamp
import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "weathers")
data class Weather(

  @Column(name = "temperature")
  val temperature: Double,

  @Column(name = "humidity")
  val humidity: Double,

  @Column(name = "pressure")
  val pressure: Int,

  @Column(name = "pm1")
  val pm1: Int,

  @Column(name = "pm25")
  val pm25: Int,

  @Column(name = "pm10")
  val pm10: Int,

  @Column(name = "wind_speed_max")
  val windSpeedMax: Double,

  @Column(name = "wind_speed_avg")
  val windSpeedAvg: Double,

  @Column(name = "rain_gauge")
  val rainGauge: Double,

  @Column(name = "latitude")
  val latitude: Double?,

  @Column(name = "longitude")
  val longitude: Double?,

  @Column(name = "creation_date")
  @CreationTimestamp
  val creationDate: Timestamp = Timestamp(0),

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null
) {

  constructor() : this(0.0, 0.0, 0, 0, 0, 0, 0.0, 0.0, 0.0, null, null)
}