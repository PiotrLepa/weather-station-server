package pl.piotr.weatherstation.weather.util

import org.springframework.stereotype.Component
import pl.piotr.weatherstation.core.extensions.toNullIfBlank

@Component
class WeatherAddressFormatter {

  fun format(city: String?, street: String?): String? =
    listOfNotNull(street, city).joinToString(separator = ", ").toNullIfBlank()
}
