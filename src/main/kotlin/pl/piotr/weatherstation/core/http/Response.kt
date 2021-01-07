package pl.piotr.weatherstation.core.http

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

data class Response(
  val body: String,
) {
  inline fun <reified T> toClass(): T? = try {
    jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
      .readValue(body)
  } catch (e: Exception) {
    null
  }
}
