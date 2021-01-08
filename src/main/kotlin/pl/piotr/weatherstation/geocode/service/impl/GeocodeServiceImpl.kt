package pl.piotr.weatherstation.geocode.service.impl

import org.springframework.stereotype.Service
import pl.piotr.weatherstation.core.http.HttpClientWrapper
import pl.piotr.weatherstation.geocode.domain.converter.GeocodeAddressConverter
import pl.piotr.weatherstation.geocode.domain.dto.GeocodedAddressDto
import pl.piotr.weatherstation.geocode.service.GeocodeService
import pl.piotr.weatherstation.util.GoogleCloudKeyProvider

@Service
class GeocodeServiceImpl(
  private val httpClient: HttpClientWrapper,
  private val googleCloudKeyProvider: GoogleCloudKeyProvider,
  private val geocodeAddressConverter: GeocodeAddressConverter,
) : GeocodeService {

  override fun reverse(latitude: Double, longitude: Double): GeocodedAddressDto? = httpClient.execute(
    API_URL,
    queryParams = listOf(
      "key" to googleCloudKeyProvider.key,
      "latlng" to "$latitude, $longitude",
    )
  )
    ?.let(geocodeAddressConverter::toGeocodeResponse)
    ?.let { geocodeAddressConverter.toDto(it, latitude, longitude) }

  companion object {
    const val API_URL = "https://maps.googleapis.com/maps/api/geocode/json"
  }
}
