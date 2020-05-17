package pl.piotr.weatherstation.core.exception

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import pl.piotr.weatherstation.core.extensions.getLocalizedMessage

@ControllerAdvice
class GameEndedExceptionHandlerAdvice @Autowired constructor(
  private val messageSource: MessageSource
) {

//  @ExceptionHandler(PasswordsAreDifferentException::class)
//  fun handlePasswordsAreDifferentException(exception: PasswordsAreDifferentException) =
//      createErrorResponse(HttpStatus.BAD_REQUEST, exception, "user.error.passwords_are_different")

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
              exception = exception,
              printableMessage = messageKey?.let { messageSource.getLocalizedMessage(it, messageArgs) }
          ))
}