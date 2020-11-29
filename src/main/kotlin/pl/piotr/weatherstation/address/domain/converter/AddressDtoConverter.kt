package pl.piotr.weatherstation.address.domain.converter

import org.springframework.stereotype.Component
import pl.piotr.weatherstation.address.domain.dto.AddressDto
import pl.piotr.weatherstation.address.domain.entity.Address
import pl.piotr.weatherstation.core.converter.Converter

@Component
class AddressDtoConverter : Converter<Address, AddressDto> {

  override fun convert(from: Address) = AddressDto(
      latitude = from.latitude,
      longitude = from.longitude,
      city = from.city,
      street = from.street,
      addressId = from.addressId!!,
  )
}
