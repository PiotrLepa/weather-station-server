package pl.piotr.weatherstation.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class GoogleCloudKeyProvider @Autowired constructor(
  @Value("\${app.google-cloud-platform-key}") val key: String,
)
