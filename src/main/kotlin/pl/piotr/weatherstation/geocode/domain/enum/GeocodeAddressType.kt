package pl.piotr.weatherstation.geocode.domain.enum

enum class GeocodeAddressType(val apiType: String) {
  STREET("route"),
  CITY("locality"),
}
