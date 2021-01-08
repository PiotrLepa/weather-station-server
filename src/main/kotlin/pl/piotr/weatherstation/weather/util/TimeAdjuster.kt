package pl.piotr.weatherstation.weather.util

import org.springframework.stereotype.Component
import java.util.TimeZone

@Component
class TimeAdjuster {

  fun adjustHour(hour: Int, zone: TimeZone): Int {
    val adjustedToZone = (hour + getHourOffSet(zone))
    return if (adjustedToZone == 24) 0 else adjustedToZone
  }

  fun getHourOffSet(zone: TimeZone): Int = zone.rawOffset / 1000 / 60 / 60
}
