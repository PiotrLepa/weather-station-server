package pl.piotr.weatherstation.core.exception

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import pl.piotr.weatherstation.core.extensions.getLocalizedMessage
import java.time.LocalDateTime

@ControllerAdvice
class ExceptionAdvice @Autowired constructor(
  private val messageSource: MessageSource
) {

  @ExceptionHandler(Exception::class)
  fun handleGenericExceptions(exception: Exception): ResponseEntity<ErrorResponse> =
    createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception)

  private fun createErrorResponse(
    status: HttpStatus,
    exception: Exception,
    messageKey: String? = null,
    vararg messageArgs: Any = arrayOf()
  ): ResponseEntity<ErrorResponse> =
    ResponseEntity
      .status(status)
      .body(ErrorResponse(
        code = status.value(),
        timestamp = LocalDateTime.now(),
        developerMessage = exception.stackTraceToString(),
        printableMessage = messageKey?.let { messageSource.getLocalizedMessage(it, messageArgs) }
      )).also { LOGGER.error(it.toString()) }

  companion object {
    private val LOGGER = LoggerFactory.getLogger(ExceptionAdvice::class.java)
  }
}
