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
    city = parseCity(from),
    street = parseStreet(from),
  )

  private fun parseCity(from: GeocodeResponse): String? = from.results
    .mapNotNull { it.addressComponents.firstOrNull { GeocodeAddressType.CITY.apiType in it.types } }
    .firstOrNull()
    ?.longName

  private fun parseStreet(from: GeocodeResponse): String? = from.results
    .mapNotNull { it.addressComponents.firstOrNull { GeocodeAddressType.STREET.apiType in it.types } }
    .firstOrNull { it.longName != "Unnamed Road" }
    ?.longName
}
