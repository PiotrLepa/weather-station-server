package pl.piotr.weatherstation.geocode.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class AddressComponent(
  @JsonProperty("long_name")
  val longName: String,

  @JsonProperty("short_name")
  val shortName: String,

  val types: List<String>,
)
