package pl.piotr.weatherstation.weather.domain.entity

import pl.piotr.weatherstation.address.domain.entity.Address
import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "weathers")
data class Weather(

  @Column(name = "temperature", nullable = false)
  val temperature: Float,

  @Column(name = "humidity", nullable = false)
  val humidity: Float,

  @Column(name = "pressure", nullable = false)
  val pressure: Int,

  @Column(name = "pm1", nullable = false)
  val pm1: Int,

  @Column(name = "pm25", nullable = false)
  val pm25: Int,

  @Column(name = "pm10", nullable = false)
  val pm10: Int,

  @Column(name = "wind_speed_max", nullable = false)
  val windSpeedMax: Float,

  @Column(name = "wind_speed_avg", nullable = false)
  val windSpeedAvg: Float,

  @Column(name = "rain_gauge", nullable = false)
  val rainGauge: Float,

  @ManyToOne(cascade = [CascadeType.ALL])
  @JoinColumn(name = "address_id", referencedColumnName = "address_id")
  val address: Address?,

  @Column(name = "creation_date", nullable = false)
  val creationDate: LocalDateTime,

  @Id
  @Column(name = "weather_id", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val weatherId: Long? = null
) {

  constructor() : this(0.0f, 0.0f, 0, 0, 0, 0, 0.0f, 0.0f, 0.0f, Address(), LocalDateTime.now())
}
