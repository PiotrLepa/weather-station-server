package pl.piotr.weatherstation.core.extensions

import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import java.util.Locale

fun MessageSource.getLocalizedMessage(code: String, vararg args: Any): String =
    getMessage(code, args, LocaleContextHolder.getLocale())

fun MessageSource.getMessageForLocale(code: String, locale: Locale, vararg args: Any): String =
    getMessage(code, args, locale)

fun MessageSource.getMessageForTag(code: String, languageTag: String, vararg args: Any): String =
    getMessage(code, args, Locale.forLanguageTag(languageTag))
