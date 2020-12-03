package pl.piotr.weatherstation.geocode.service.impl

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import pl.piotr.weatherstation.core.converter.ConverterWithArgs
import pl.piotr.weatherstation.geocode.domain.converter.GeocodedAddressDtoConverterArgs
import pl.piotr.weatherstation.geocode.domain.dto.GeocodedAddressDto
import pl.piotr.weatherstation.geocode.domain.entity.GeocodeResponse
import pl.piotr.weatherstation.geocode.service.GeocodeService

@Service
class GeocodeServiceImpl(
  @Value("\${app.google-cloud-platform-key}")
  private val googleCloudPlatformKey: String,
  private val httpClient: OkHttpClient,
  private val geocodedAddressDtoConverter: ConverterWithArgs<GeocodeResponse, GeocodedAddressDto, GeocodedAddressDtoConverterArgs>,
) : GeocodeService {

  override fun reverse(latitude: Double, longitude: Double): GeocodedAddressDto? {
    val url = createBaseUrl().addQueryParameter("latlng", "$latitude, $longitude")
      .build()

    return executeRequest(url)
      ?.let { geocodedAddressDtoConverter.convert(it, GeocodedAddressDtoConverterArgs(latitude, longitude)) }
  }

  private fun createBaseUrl(): HttpUrl.Builder = API_URL.toHttpUrl()
    .newBuilder()
    .addQueryParameter("key", googleCloudPlatformKey)

  private fun executeRequest(url: HttpUrl): GeocodeResponse? {
    val request = Request.Builder()
      .url(url)
      .build()

    return httpClient.newCall(request)
      .execute()
      .body
      ?.string()
      ?.let {
        jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
          .readValue<GeocodeResponse>(it)
      }
  }

  companion object {
    private const val API_URL = "https://maps.googleapis.com/maps/api/geocode/json"
  }
}
