package pl.piotr.weatherstation.address.domain.dto

data class AddressDto(
  val latitude: Double,
  val longitude: Double,
  val city: String,
  val street: String?,
  val addressId: Long,
)
