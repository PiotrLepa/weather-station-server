package pl.piotr.weatherstation.core.firebase

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class FirebaseConfiguration @Autowired constructor(
  @Value("\${app.firebase-configuration-file}")
  private val firebaseConfigPath: String,
  @Value("\${app.firebase-database-url}")
  private val firebaseDatabaseUrl: String
) {

  @PostConstruct
  fun initialize() {
    if (FirebaseApp.getApps() == null || FirebaseApp.getApps().isNotEmpty()) {
      return
    }

    val options = FirebaseOptions.builder()
      .setCredentials(GoogleCredentials.fromStream(ClassPathResource(firebaseConfigPath).inputStream))
      .setDatabaseUrl(firebaseDatabaseUrl)
      .build()
    FirebaseApp.initializeApp(options)
  }

  @Bean
  fun firebaseMessaging(): FirebaseMessaging = FirebaseMessaging.getInstance()
}
