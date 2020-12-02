package pl.piotr.weatherstation.core.extensions

import kotlin.math.round

fun Number.roundToDecimals(decimals: Int): Double {
  var multiplier = 1.0
  repeat(decimals) { multiplier *= 10 }
  return when (this) {
    is Double -> round(this * multiplier) / multiplier
    is Float -> round(this * multiplier) / multiplier
    else -> this.toDouble()
  }
}
