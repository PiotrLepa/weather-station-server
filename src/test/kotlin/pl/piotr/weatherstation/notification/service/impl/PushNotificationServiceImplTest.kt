package pl.piotr.weatherstation.notification.service.impl

import com.google.firebase.messaging.FirebaseMessaging
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.context.MessageSource
import pl.piotr.weatherstation.core.extensions.getMessageForLocale
import pl.piotr.weatherstation.core.language.LocaleProvider
import java.util.Locale

@ExtendWith(MockKExtension::class)
class PushNotificationServiceImplTest {

  private val firebaseMessaging: FirebaseMessaging = mockk()
  private val messageSource: MessageSource = mockk()
  private val localeProvider: LocaleProvider = mockk()

  @InjectMockKs
  lateinit var pushNotificationService: PushNotificationServiceImpl

  @Test
  fun `should send push notification for all supported locale`() {
    // given
    val locales = listOf(Locale.ENGLISH, Locale.forLanguageTag("pl"))

    every { localeProvider.supportedLocales } returns locales
    every { messageSource.getMessageForLocale(any(), any()) } returns "message"
    every { firebaseMessaging.send(any()) } returns "message_id"

    // when
    pushNotificationService.sendRainDetected()

    // then
    verify(exactly = locales.size) { firebaseMessaging.send(any()) }
  }
}
