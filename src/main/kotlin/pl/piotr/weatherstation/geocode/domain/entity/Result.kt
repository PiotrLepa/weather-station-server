package pl.piotr.weatherstation.geocode.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class Result(
  @JsonProperty("address_components")
  val addressComponents: List<AddressComponent>,
)
