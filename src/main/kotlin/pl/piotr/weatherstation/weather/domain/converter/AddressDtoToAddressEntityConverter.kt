package pl.piotr.weatherstation.weather.domain.converter

import org.springframework.stereotype.Component
import pl.piotr.weatherstation.address.domain.dto.AddressDto
import pl.piotr.weatherstation.address.domain.entity.Address
import pl.piotr.weatherstation.core.converter.Converter
import java.time.LocalDateTime

@Component
class AddressDtoToAddressEntityConverter : Converter<AddressDto, Address> {

  override fun convert(from: AddressDto) = Address(
      latitude = from.latitude,
      longitude = from.longitude,
      city = from.city,
      street = from.street,
      creationDate = LocalDateTime.now(),
      addressId = from.addressId,
  )
}
