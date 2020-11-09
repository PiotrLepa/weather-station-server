package pl.piotr.weatherstation.notification.enum

import java.util.Locale

enum class NotificationTopic(val topicName: String) {
  RAIN_DETECTED("rain_detected");

  fun withLocale(locale: Locale): String = "$topicName$DIVIDER${locale.toLanguageTag()}"

  companion object {
    private const val DIVIDER = "_"
  }
}
