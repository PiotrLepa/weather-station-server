package pl.piotr.weatherstation.geocode.service.impl

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.piotr.weatherstation.core.http.HttpClientWrapper
import pl.piotr.weatherstation.core.http.Response
import pl.piotr.weatherstation.geocode.domain.converter.GeocodeAddressConverter
import pl.piotr.weatherstation.geocode.domain.entity.GeocodeResponse
import pl.piotr.weatherstation.util.GoogleCloudKeyProvider

@ExtendWith(MockKExtension::class)
class GeocodeServiceImplTest {

  private val googleCloudKeyProvider: GoogleCloudKeyProvider = mockk {
    every { key } returns "key"
  }
  private val httpClientWrapper: HttpClientWrapper = mockk()
  private val geocodeAddressConverter: GeocodeAddressConverter = mockk()

  @InjectMockKs
  lateinit var geocodeService: GeocodeServiceImpl

  @Test
  fun `reverse geocode should return dto with correct data if http request returns success`() {
    // given
    val (lat, long) = 52.229676 to 21.012229
    val dto = getGeocodedAddressDto()
    val httpResponse = Response("json")
    val geocodeResponse = GeocodeResponse(results = listOf())

    every { httpClientWrapper.execute(any(), any()) } returns httpResponse
    every { geocodeAddressConverter.toGeocodeResponse(httpResponse) } returns geocodeResponse
    every { geocodeAddressConverter.toDto(any(), lat, long) } returns dto

    // when
    val resultDto = geocodeService.reverse(lat, long)

    // then
    assert(resultDto == dto)
  }

  @Test
  fun `reverse geocode should return null if http request fails`() {
    // given
    val (lat, long) = 52.229676 to 21.012229
    val dto = getGeocodedAddressDto()

    every { httpClientWrapper.execute(any(), any()) } returns null
    every { geocodeAddressConverter.toDto(any(), lat, long) } returns dto

    // when
    val resultDto = geocodeService.reverse(lat, long)

    // then
    assert(resultDto == null)
  }

}
