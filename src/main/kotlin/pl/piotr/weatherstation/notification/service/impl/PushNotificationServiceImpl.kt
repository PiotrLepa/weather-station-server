package pl.piotr.weatherstation.notification.service.impl

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import pl.piotr.weatherstation.core.extensions.getMessageForLocale
import pl.piotr.weatherstation.core.language.LocaleProvider
import pl.piotr.weatherstation.notification.enum.NotificationTopic
import pl.piotr.weatherstation.notification.enum.NotificationType
import pl.piotr.weatherstation.notification.service.PushNotificationService
import java.util.Locale

@Service
class PushNotificationServiceImpl @Autowired constructor(
  private val firebaseMessaging: FirebaseMessaging,
  private val messageSource: MessageSource,
  private val localeProvider: LocaleProvider,
) : PushNotificationService {

  @Async
  override fun sendRainDetected() {
    localeProvider.supportedLocales.forEach(::sendRainDetectedForLanguage)
  }

  private fun sendRainDetectedForLanguage(locale: Locale) {
    val title = messageSource.getMessageForLocale("notification.rain_detected.title", locale)
    val body = messageSource.getMessageForLocale("notification.rain_detected.body", locale)
    val message = Message.builder()
      .setTopic(NotificationTopic.RAIN_DETECTED.withLocale(locale))
      .setNotification(
        Notification.builder()
          .setTitle(title)
          .setBody(body)
          .build()
      )
      .putAllData(
        mapOf(
          NOTIFICATION_TYPE to NotificationType.RAIN_DETECTED.toString()
        )
      )
      .build()
    firebaseMessaging.send(message)
  }

  private fun getFlutterClickAction(): Pair<String, String> =
    FLUTTER_CLICK_ACTION_KEY to FLUTTER_CLICK_ACTION_VALUE

  companion object {
    private const val FLUTTER_CLICK_ACTION_KEY = "click_action"
    private const val FLUTTER_CLICK_ACTION_VALUE = "FLUTTER_NOTIFICATION_CLICK"

    private const val NOTIFICATION_TYPE = "TYPE"
  }
}
