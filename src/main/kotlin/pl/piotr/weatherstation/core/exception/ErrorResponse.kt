package pl.piotr.weatherstation.core.exception

import java.time.LocalDateTime

data class ErrorResponse(
  val code: Int,
  val timestamp: LocalDateTime,
  val developerMessage: String,
  val printableMessage: String? = null
)
