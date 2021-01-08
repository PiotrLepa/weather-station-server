package pl.piotr.weatherstation.geocode.domain.dto

data class GeocodedAddressDto(
  val latitude: Double,
  val longitude: Double,
  val city: String?,
  val street: String?,
)
