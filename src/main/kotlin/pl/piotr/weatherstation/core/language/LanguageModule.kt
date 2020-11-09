package pl.piotr.weatherstation.core.language

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource

@Configuration
class LanguageModule(
  private val localeProvider: LocaleProvider,
) {
  @Bean
  fun messageSource(): MessageSource = ResourceBundleMessageSource()
      .apply {
        setBasename("i18n/messages")
        setDefaultEncoding("UTF-8")
        setFallbackToSystemLocale(false)
        setDefaultLocale(localeProvider.defaultLocale)
      }
}
