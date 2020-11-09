package pl.piotr.weatherstation.core.firebase

import com.google.firebase.messaging.FirebaseMessaging
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FirebaseModule {

  @Bean
  fun firebaseMessaging(): FirebaseMessaging = FirebaseMessaging.getInstance()
}
