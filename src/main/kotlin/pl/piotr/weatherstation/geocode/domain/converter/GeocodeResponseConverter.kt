package pl.piotr.weatherstation.geocode.domain.converter

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.stereotype.Component
import pl.piotr.weatherstation.core.converter.Converter
import pl.piotr.weatherstation.core.http.Response
import pl.piotr.weatherstation.geocode.domain.entity.GeocodeResponse

@Component
class GeocodeResponseConverter : Converter<Response, GeocodeResponse?> {

  override fun convert(from: Response): GeocodeResponse? = from.body?.let {
    try {
      jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .readValue(it)
    } catch (e: Exception) {
      null
    }
  }

}
