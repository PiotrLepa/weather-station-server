package pl.piotr.weatherstation.notification.service

import org.springframework.scheduling.annotation.Async

interface PushNotificationService {

  @Async
  fun sendRainDetected()

}
