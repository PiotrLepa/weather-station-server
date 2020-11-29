package pl.piotr.weatherstation.geocode.service

import pl.piotr.weatherstation.geocode.domain.dto.GeocodedAddressDto

interface GeocodeService {

  fun reverse(latitude: Double, longitude: Double): GeocodedAddressDto?

}
