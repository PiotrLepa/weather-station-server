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

  @Column(name = "creation_date")
  @CreationTimestamp
  val creationDate: Timestamp = Timestamp(0),

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null
) {

  constructor() : this(0.0)
}