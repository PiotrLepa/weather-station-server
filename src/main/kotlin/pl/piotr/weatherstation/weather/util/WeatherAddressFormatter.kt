package pl.piotr.weatherstation.weather.util

import org.springframework.stereotype.Component

@Component
class WeatherAddressFormatter {

  fun format(city: String, street: String?): String? =
      if (street != null) {
        "$street, $city"
      } else {
        city
      }
}
