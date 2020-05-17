package pl.piotr.weatherstation.core.extensions

import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder

fun MessageSource.getLocalizedMessage(code: String, vararg args: Any): String =
    getMessage(code, args, LocaleContextHolder.getLocale())