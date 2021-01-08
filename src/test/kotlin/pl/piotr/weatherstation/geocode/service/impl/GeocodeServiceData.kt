package pl.piotr.weatherstation.geocode.service.impl

import pl.piotr.weatherstation.geocode.domain.dto.GeocodedAddressDto
import pl.piotr.weatherstation.weather.domain.entity.Address
import java.time.LocalDateTime

fun getAddress(): Address = Address(
  latitude = 52.229676,
  longitude = 21.012229,
  city = "Warsaw",
  street = "Śródmieście",
  creationDate = LocalDateTime.of(2020, 7, 12, 13, 5, 0)
)

fun getGeocodedAddressDto(): GeocodedAddressDto = GeocodedAddressDto(
  latitude = 52.229676,
  longitude = 21.012229,
  city = "Warsaw",
  street = "Śródmieście",
)
