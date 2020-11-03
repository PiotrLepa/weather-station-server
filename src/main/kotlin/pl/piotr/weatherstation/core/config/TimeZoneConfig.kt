package pl.piotr.weatherstation.core.config

import org.springframework.context.annotation.Configuration
import java.util.TimeZone
import javax.annotation.PostConstruct

@Configuration
class TimeZoneConfig {

  @PostConstruct
  fun init() {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
  }
}
