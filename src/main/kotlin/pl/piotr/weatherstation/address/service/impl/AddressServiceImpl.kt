package pl.piotr.weatherstation.address.service.impl

import org.springframework.stereotype.Service
import pl.piotr.weatherstation.address.domain.dto.AddressDto
import pl.piotr.weatherstation.address.domain.entity.Address
import pl.piotr.weatherstation.address.repository.AddressRepository
import pl.piotr.weatherstation.address.service.AddressService
import pl.piotr.weatherstation.core.converter.Converter

@Service
class AddressServiceImpl(
  private val addressRepository: AddressRepository,
  private val addressDtoConverter: Converter<Address, AddressDto>,
) : AddressService {

  override fun getClosest(latitude: Double, longitude: Double): AddressDto? =
      addressRepository.getClosestAddress(latitude, longitude)?.let(addressDtoConverter::convert)

}
