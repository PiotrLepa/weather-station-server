package pl.piotr.weatherstation.core.http.converter

import org.springframework.stereotype.Component
import pl.piotr.weatherstation.core.converter.Converter
import pl.piotr.weatherstation.core.http.Response

@Component
class ResponseConverter : Converter<okhttp3.Response, Response> {

  override fun convert(from: okhttp3.Response) = Response(
    body = from.body?.string(),
  )
}
