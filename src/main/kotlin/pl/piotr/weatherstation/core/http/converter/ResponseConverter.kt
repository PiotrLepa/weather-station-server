package pl.piotr.weatherstation.core.http.converter

import org.springframework.stereotype.Component
import pl.piotr.weatherstation.core.http.Response

@Component
class ResponseConverter {

  fun toResponse(from: okhttp3.Response) = Response(
    body = from.body?.string(),
  )
}
