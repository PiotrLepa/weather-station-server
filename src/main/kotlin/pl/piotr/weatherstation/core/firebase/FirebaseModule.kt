package pl.piotr.weatherstation.core.firebase

import com.google.firebase.messaging.FirebaseMessaging
import org.springframework.context.annotation.Bean

@Bean
fun firebaseMessaging(): FirebaseMessaging = FirebaseMessaging.getInstance()
