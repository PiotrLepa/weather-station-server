package pl.piotr.weatherstation.address.service

import pl.piotr.weatherstation.address.domain.dto.AddressDto

interface AddressService {

  fun getClosest(latitude: Double, longitude: Double): AddressDto?

}
