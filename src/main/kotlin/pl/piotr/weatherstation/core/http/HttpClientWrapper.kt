package pl.piotr.weatherstation.core.http

import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import pl.piotr.weatherstation.core.http.converter.ResponseConverter

@Component
class HttpClientWrapper @Autowired constructor(
  private val httpClient: OkHttpClient,
  private val responseConverter: ResponseConverter,
) {

  fun execute(
    url: String,
    queryParams: List<Pair<String, String>> = listOf()
  ): Response? {
    val httpUrl = url.toHttpUrl()
      .newBuilder()
      .apply {
        queryParams.forEach { query ->
          addQueryParameter(query.first, query.second)
        }
      }
      .build()

    val request = Request.Builder()
      .url(httpUrl)
      .build()

    return httpClient.newCall(request)
      .execute()
      .let(responseConverter::convert)
  }

}
