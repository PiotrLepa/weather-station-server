package pl.piotr.weatherstation.weather.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pl.piotr.weatherstation.weather.domain.entity.Weather

@Repository
interface WeatherRepository : JpaRepository<Weather, Long> {

  fun findFirstByOrderByCreationDateDesc(): Weather
}