package pl.piotr.weatherstation.weather.util

import org.springframework.stereotype.Component
import java.time.Instant
import java.util.TimeZone
import kotlin.math.abs

@Component
class TimeAdjuster {

  fun adjustHour(hour: Int, zone: TimeZone): Int {
    val adjustedToZone = (hour + getHoursOffSet(zone))
    return if (adjustedToZone >= 24) abs(adjustedToZone - 24) else adjustedToZone
  }

  fun getHoursOffSet(zone: TimeZone): Int = zone.getOffset(Instant.now().toEpochMilli()) / 1000 / 60 / 60

}
