package pl.piotr.weatherstation.address.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import pl.piotr.weatherstation.address.domain.entity.Address

@Repository
interface AddressRepository : JpaRepository<Address, Long> {

  @Query(
      nativeQuery = true,
      value = """
      SELECT a.latitude, a.longitude, a.city, a.street, a.creation_date, a.address_id FROM addresses AS a 
      WHERE ABS(a.latitude - :latitude) < 0.001 AND ABS(a.longitude - :longitude) < 0.001
        """
  )
  fun getClosestAddress(
    @Param("latitude") latitude: Double,
    @Param("longitude") longitude: Double
  ): Address?

}
