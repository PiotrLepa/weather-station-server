package pl.piotr.weatherstation.geocode.domain.converter

import org.springframework.stereotype.Component
import pl.piotr.weatherstation.core.converter.ConverterWithArgs
import pl.piotr.weatherstation.geocode.domain.dto.GeocodedAddressDto
import pl.piotr.weatherstation.geocode.domain.entity.GeocodeResponse
import pl.piotr.weatherstation.geocode.domain.enum.GeocodeAddressType

@Component
class GeocodedAddressDtoConverter : ConverterWithArgs<GeocodeResponse, GeocodedAddressDto, GeocodedAddressDtoConverterArgs> {

  override fun convert(from: GeocodeResponse, args: GeocodedAddressDtoConverterArgs) = GeocodedAddressDto(
      latitude = args.latitude,
      longitude = args.longitude,
      city = from.results.first().addressComponents.first { GeocodeAddressType.CITY.apiType in it.types }.longName,
      street = from.results.first().addressComponents.find { GeocodeAddressType.STREET.apiType in it.types }?.longName,
  )
}
