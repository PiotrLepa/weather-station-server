package pl.piotr.weatherstation.weather.domain.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "addresses")
data class Address(

  @Column(name = "latitude")
  val latitude: Double,

  @Column(name = "longitude")
  val longitude: Double,

  @Column(name = "city")
  val city: String,

  @Column(name = "street")
  val street: String?,

  @Column(name = "creation_date", nullable = false)
  val creationDate: LocalDateTime,

  @Id
  @Column(name = "address_id", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val addressId: Long? = null
) {

  constructor () : this(0.0, 0.0, "", null, LocalDateTime.now())
}
