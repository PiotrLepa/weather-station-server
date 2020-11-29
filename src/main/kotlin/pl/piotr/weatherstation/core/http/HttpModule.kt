package pl.piotr.weatherstation.core.http

import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HttpModule {

  @Bean
  fun okHttpClient(): OkHttpClient = OkHttpClient()
}
