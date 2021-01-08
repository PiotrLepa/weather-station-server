package pl.piotr.weatherstation.geocode.domain.converter

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.stereotype.Component
import pl.piotr.weatherstation.core.http.Response
import pl.piotr.weatherstation.geocode.domain.dto.GeocodedAddressDto
import pl.piotr.weatherstation.geocode.domain.entity.GeocodeResponse
import pl.piotr.weatherstation.geocode.domain.enum.GeocodeAddressType
import pl.piotr.weatherstation.weather.domain.entity.Address
import java.time.LocalDateTime

@Component
class GeocodeAddressConverter {

  fun toDto(
    from: GeocodeResponse,
    latitude: Double,
    longitude: Double,
  ) = GeocodedAddressDto(
    latitude = latitude,
    longitude = longitude,
    city = parseCity(from),
    street = parseStreet(from),
  )

  fun toEntity(from: GeocodedAddressDto) = Address(
    latitude = from.latitude,
    longitude = from.longitude,
    city = from.city,
    street = from.street,
    LocalDateTime.now(),
  )

  fun toGeocodeResponse(from: Response): GeocodeResponse? = from.body?.let {
    try {
      jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .readValue(it)
    } catch (e: Exception) {
      null
    }
  }

  private fun parseCity(from: GeocodeResponse): String? = from.results
    .mapNotNull { it.addressComponents.firstOrNull { GeocodeAddressType.CITY.apiType in it.types } }
    .firstOrNull()
    ?.longName

  private fun parseStreet(from: GeocodeResponse): String? = from.results
    .mapNotNull { it.addressComponents.firstOrNull { GeocodeAddressType.STREET.apiType in it.types } }
    .firstOrNull { it.longName != "Unnamed Road" }
    ?.longName
}
