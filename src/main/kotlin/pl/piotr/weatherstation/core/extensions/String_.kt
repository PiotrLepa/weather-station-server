package pl.piotr.weatherstation.core.extensions

fun String.toNullIfBlank(): String? = if (isBlank()) null else this
