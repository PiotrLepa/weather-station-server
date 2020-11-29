package pl.piotr.weatherstation.weather.domain.converter

import org.springframework.stereotype.Component
import pl.piotr.weatherstation.address.domain.entity.Address
import pl.piotr.weatherstation.core.converter.Converter
import pl.piotr.weatherstation.geocode.domain.dto.GeocodedAddressDto
import java.time.LocalDateTime

@Component
class GeocodedAddressDtoToAddressEntityConverter : Converter<GeocodedAddressDto, Address> {

  override fun convert(from: GeocodedAddressDto) = Address(
      latitude = from.latitude,
      longitude = from.longitude,
      city = from.city,
      street = from.street,
      LocalDateTime.now(),
  )
}
