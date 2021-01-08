package pl.piotr.weatherstation.core.language

import org.springframework.stereotype.Component
import java.util.Locale

@Component
class LocaleProvider {

  final val defaultLocale: Locale = Locale.ENGLISH

  final val supportedLocales = listOf(Locale.ENGLISH, Locale.forLanguageTag("pl"))
  final val supportedLanguageCodes = supportedLocales.map { it.toLanguageTag() }
}
