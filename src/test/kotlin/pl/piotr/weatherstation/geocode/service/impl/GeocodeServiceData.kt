package pl.piotr.weatherstation.geocode.service.impl

import pl.piotr.weatherstation.geocode.domain.dto.GeocodedAddressDto
import pl.piotr.weatherstation.weather.domain.entity.Address
import java.time.LocalDateTime

fun getAddress(): Address = Address(
  latitude = 52.229676,
  longitude = 21.012229,
  city = "Warsaw",
  street = "Śródmieście",
  creationDate = LocalDateTime.of(2020, 7, 12, 13, 5, 0)
)

fun getGeocodedAddressDto(): GeocodedAddressDto = GeocodedAddressDto(
  latitude = 52.229676,
  longitude = 21.012229,
  city = "Warsaw",
  street = "Śródmieście",
)

fun getReverseGeocodeJson(): String {
  return "{\n" +
      "   \"plus_code\" : {\n" +
      "      \"compound_code\" : \"2X6P+R8 Tuchla-Osada, Poland\",\n" +
      "      \"global_code\" : \"9G242X6P+R8\"\n" +
      "   },\n" +
      "   \"results\" : [\n" +
      "      {\n" +
      "         \"address_components\" : [\n" +
      "            {\n" +
      "               \"long_name\" : \"11\",\n" +
      "               \"short_name\" : \"11\",\n" +
      "               \"types\" : [ \"street_number\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Tuchla Osada\",\n" +
      "               \"short_name\" : \"Tuchla Osada\",\n" +
      "               \"types\" : [ \"route\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Powiat jarosławski\",\n" +
      "               \"short_name\" : \"Powiat jarosławski\",\n" +
      "               \"types\" : [ \"administrative_area_level_2\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Podkarpackie\",\n" +
      "               \"short_name\" : \"Podkarpackie\",\n" +
      "               \"types\" : [ \"administrative_area_level_1\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Poland\",\n" +
      "               \"short_name\" : \"PL\",\n" +
      "               \"types\" : [ \"country\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"37-545\",\n" +
      "               \"short_name\" : \"37-545\",\n" +
      "               \"types\" : [ \"postal_code\" ]\n" +
      "            }\n" +
      "         ],\n" +
      "         \"formatted_address\" : \"Tuchla Osada 11, 37-545, Poland\",\n" +
      "         \"geometry\" : {\n" +
      "            \"location\" : {\n" +
      "               \"lat\" : 50.00579339999999,\n" +
      "               \"lng\" : 22.9968846\n" +
      "            },\n" +
      "            \"location_type\" : \"RANGE_INTERPOLATED\",\n" +
      "            \"viewport\" : {\n" +
      "               \"northeast\" : {\n" +
      "                  \"lat\" : 50.0071423802915,\n" +
      "                  \"lng\" : 22.9982335802915\n" +
      "               },\n" +
      "               \"southwest\" : {\n" +
      "                  \"lat\" : 50.0044444197085,\n" +
      "                  \"lng\" : 22.99553561970849\n" +
      "               }\n" +
      "            }\n" +
      "         },\n" +
      "         \"place_id\" : \"Eh9UdWNobGEgT3NhZGEgMTEsIDM3LTU0NSwgUG9sYW5kIhoSGAoUChIJ7Y5HlCtnO0cR8j7D1-4U8RoQCw\",\n" +
      "         \"types\" : [ \"street_address\" ]\n" +
      "      },\n" +
      "      {\n" +
      "         \"address_components\" : [\n" +
      "            {\n" +
      "               \"long_name\" : \"9-13\",\n" +
      "               \"short_name\" : \"9-13\",\n" +
      "               \"types\" : [ \"street_number\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Tuchla Osada\",\n" +
      "               \"short_name\" : \"Tuchla Osada\",\n" +
      "               \"types\" : [ \"route\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Powiat jarosławski\",\n" +
      "               \"short_name\" : \"Powiat jarosławski\",\n" +
      "               \"types\" : [ \"administrative_area_level_2\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Podkarpackie\",\n" +
      "               \"short_name\" : \"Podkarpackie\",\n" +
      "               \"types\" : [ \"administrative_area_level_1\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Poland\",\n" +
      "               \"short_name\" : \"PL\",\n" +
      "               \"types\" : [ \"country\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"37-545\",\n" +
      "               \"short_name\" : \"37-545\",\n" +
      "               \"types\" : [ \"postal_code\" ]\n" +
      "            }\n" +
      "         ],\n" +
      "         \"formatted_address\" : \"Tuchla Osada 9-13, 37-545, Poland\",\n" +
      "         \"geometry\" : {\n" +
      "            \"bounds\" : {\n" +
      "               \"northeast\" : {\n" +
      "                  \"lat\" : 50.0059231,\n" +
      "                  \"lng\" : 22.998315\n" +
      "               },\n" +
      "               \"southwest\" : {\n" +
      "                  \"lat\" : 50.0049912,\n" +
      "                  \"lng\" : 22.9967739\n" +
      "               }\n" +
      "            },\n" +
      "            \"location\" : {\n" +
      "               \"lat\" : 50.005423,\n" +
      "               \"lng\" : 22.9972666\n" +
      "            },\n" +
      "            \"location_type\" : \"GEOMETRIC_CENTER\",\n" +
      "            \"viewport\" : {\n" +
      "               \"northeast\" : {\n" +
      "                  \"lat\" : 50.00680613029149,\n" +
      "                  \"lng\" : 22.9988934302915\n" +
      "               },\n" +
      "               \"southwest\" : {\n" +
      "                  \"lat\" : 50.00410816970849,\n" +
      "                  \"lng\" : 22.9961954697085\n" +
      "               }\n" +
      "            }\n" +
      "         },\n" +
      "         \"place_id\" : \"ChIJ7Y5HlCtnO0cR8j7D1-4U8Ro\",\n" +
      "         \"types\" : [ \"route\" ]\n" +
      "      },\n" +
      "      {\n" +
      "         \"address_components\" : [\n" +
      "            {\n" +
      "               \"long_name\" : \"Gmina Laszki\",\n" +
      "               \"short_name\" : \"Gmina Laszki\",\n" +
      "               \"types\" : [ \"administrative_area_level_3\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Jarosław County\",\n" +
      "               \"short_name\" : \"Jarosław County\",\n" +
      "               \"types\" : [ \"administrative_area_level_2\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Podkarpackie Voivodeship\",\n" +
      "               \"short_name\" : \"Podkarpackie Voivodeship\",\n" +
      "               \"types\" : [ \"administrative_area_level_1\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Poland\",\n" +
      "               \"short_name\" : \"PL\",\n" +
      "               \"types\" : [ \"country\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"37\",\n" +
      "               \"short_name\" : \"37\",\n" +
      "               \"types\" : [ \"postal_code\", \"postal_code_prefix\" ]\n" +
      "            }\n" +
      "         ],\n" +
      "         \"formatted_address\" : \"Gmina Laszki, Poland\",\n" +
      "         \"geometry\" : {\n" +
      "            \"bounds\" : {\n" +
      "               \"northeast\" : {\n" +
      "                  \"lat\" : 50.0782181,\n" +
      "                  \"lng\" : 23.0708533\n" +
      "               },\n" +
      "               \"southwest\" : {\n" +
      "                  \"lat\" : 49.9638298,\n" +
      "                  \"lng\" : 22.7702437\n" +
      "               }\n" +
      "            },\n" +
      "            \"location\" : {\n" +
      "               \"lat\" : 50.0277386,\n" +
      "               \"lng\" : 22.9762589\n" +
      "            },\n" +
      "            \"location_type\" : \"APPROXIMATE\",\n" +
      "            \"viewport\" : {\n" +
      "               \"northeast\" : {\n" +
      "                  \"lat\" : 50.0782181,\n" +
      "                  \"lng\" : 23.0708533\n" +
      "               },\n" +
      "               \"southwest\" : {\n" +
      "                  \"lat\" : 49.9638298,\n" +
      "                  \"lng\" : 22.7702437\n" +
      "               }\n" +
      "            }\n" +
      "         },\n" +
      "         \"place_id\" : \"ChIJb-eRZFJgO0cRl5dPfKfI4dM\",\n" +
      "         \"types\" : [ \"administrative_area_level_3\", \"political\" ]\n" +
      "      },\n" +
      "      {\n" +
      "         \"address_components\" : [\n" +
      "            {\n" +
      "               \"long_name\" : \"Jarosław County\",\n" +
      "               \"short_name\" : \"Jarosław County\",\n" +
      "               \"types\" : [ \"administrative_area_level_2\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Podkarpackie Voivodeship\",\n" +
      "               \"short_name\" : \"Podkarpackie Voivodeship\",\n" +
      "               \"types\" : [ \"administrative_area_level_1\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Poland\",\n" +
      "               \"short_name\" : \"PL\",\n" +
      "               \"types\" : [ \"country\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"37\",\n" +
      "               \"short_name\" : \"37\",\n" +
      "               \"types\" : [ \"postal_code\", \"postal_code_prefix\" ]\n" +
      "            }\n" +
      "         ],\n" +
      "         \"formatted_address\" : \"Jarosław County, Poland\",\n" +
      "         \"geometry\" : {\n" +
      "            \"bounds\" : {\n" +
      "               \"northeast\" : {\n" +
      "                  \"lat\" : 50.212823,\n" +
      "                  \"lng\" : 23.1542742\n" +
      "               },\n" +
      "               \"southwest\" : {\n" +
      "                  \"lat\" : 49.836944,\n" +
      "                  \"lng\" : 22.410544\n" +
      "               }\n" +
      "            },\n" +
      "            \"location\" : {\n" +
      "               \"lat\" : 49.9657776,\n" +
      "               \"lng\" : 22.7535729\n" +
      "            },\n" +
      "            \"location_type\" : \"APPROXIMATE\",\n" +
      "            \"viewport\" : {\n" +
      "               \"northeast\" : {\n" +
      "                  \"lat\" : 50.212823,\n" +
      "                  \"lng\" : 23.1542742\n" +
      "               },\n" +
      "               \"southwest\" : {\n" +
      "                  \"lat\" : 49.836944,\n" +
      "                  \"lng\" : 22.410544\n" +
      "               }\n" +
      "            }\n" +
      "         },\n" +
      "         \"place_id\" : \"ChIJ70Pxv-yePEcRIM3kxa18AQM\",\n" +
      "         \"types\" : [ \"administrative_area_level_2\", \"political\" ]\n" +
      "      },\n" +
      "      {\n" +
      "         \"address_components\" : [\n" +
      "            {\n" +
      "               \"long_name\" : \"37\",\n" +
      "               \"short_name\" : \"37\",\n" +
      "               \"types\" : [ \"postal_code\", \"postal_code_prefix\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Poland\",\n" +
      "               \"short_name\" : \"PL\",\n" +
      "               \"types\" : [ \"country\", \"political\" ]\n" +
      "            }\n" +
      "         ],\n" +
      "         \"formatted_address\" : \"Poland\",\n" +
      "         \"geometry\" : {\n" +
      "            \"bounds\" : {\n" +
      "               \"northeast\" : {\n" +
      "                  \"lat\" : 50.8067748,\n" +
      "                  \"lng\" : 23.5191934\n" +
      "               },\n" +
      "               \"southwest\" : {\n" +
      "                  \"lat\" : 49.6003832,\n" +
      "                  \"lng\" : 21.8679975\n" +
      "               }\n" +
      "            },\n" +
      "            \"location\" : {\n" +
      "               \"lat\" : 50.25953380000001,\n" +
      "               \"lng\" : 22.8003804\n" +
      "            },\n" +
      "            \"location_type\" : \"APPROXIMATE\",\n" +
      "            \"viewport\" : {\n" +
      "               \"northeast\" : {\n" +
      "                  \"lat\" : 50.8067748,\n" +
      "                  \"lng\" : 23.5191934\n" +
      "               },\n" +
      "               \"southwest\" : {\n" +
      "                  \"lat\" : 49.6003832,\n" +
      "                  \"lng\" : 21.8679975\n" +
      "               }\n" +
      "            }\n" +
      "         },\n" +
      "         \"place_id\" : \"ChIJBYHhJXq7PEcRO0mnRmsLbEs\",\n" +
      "         \"types\" : [ \"postal_code\", \"postal_code_prefix\" ]\n" +
      "      },\n" +
      "      {\n" +
      "         \"address_components\" : [\n" +
      "            {\n" +
      "               \"long_name\" : \"Podkarpackie Voivodeship\",\n" +
      "               \"short_name\" : \"Podkarpackie Voivodeship\",\n" +
      "               \"types\" : [ \"administrative_area_level_1\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Poland\",\n" +
      "               \"short_name\" : \"PL\",\n" +
      "               \"types\" : [ \"country\", \"political\" ]\n" +
      "            }\n" +
      "         ],\n" +
      "         \"formatted_address\" : \"Podkarpackie Voivodeship, Poland\",\n" +
      "         \"geometry\" : {\n" +
      "            \"bounds\" : {\n" +
      "               \"northeast\" : {\n" +
      "                  \"lat\" : 50.8181161,\n" +
      "                  \"lng\" : 23.5476409\n" +
      "               },\n" +
      "               \"southwest\" : {\n" +
      "                  \"lat\" : 49.0020252,\n" +
      "                  \"lng\" : 21.1423458\n" +
      "               }\n" +
      "            },\n" +
      "            \"location\" : {\n" +
      "               \"lat\" : 50.0574749,\n" +
      "               \"lng\" : 22.0895691\n" +
      "            },\n" +
      "            \"location_type\" : \"APPROXIMATE\",\n" +
      "            \"viewport\" : {\n" +
      "               \"northeast\" : {\n" +
      "                  \"lat\" : 50.8181161,\n" +
      "                  \"lng\" : 23.5476409\n" +
      "               },\n" +
      "               \"southwest\" : {\n" +
      "                  \"lat\" : 49.0020252,\n" +
      "                  \"lng\" : 21.1423458\n" +
      "               }\n" +
      "            }\n" +
      "         },\n" +
      "         \"place_id\" : \"ChIJtWGj2--LPEcRoMDkxa18AQE\",\n" +
      "         \"types\" : [ \"administrative_area_level_1\", \"political\" ]\n" +
      "      },\n" +
      "      {\n" +
      "         \"address_components\" : [\n" +
      "            {\n" +
      "               \"long_name\" : \"Poland\",\n" +
      "               \"short_name\" : \"PL\",\n" +
      "               \"types\" : [ \"country\", \"political\" ]\n" +
      "            }\n" +
      "         ],\n" +
      "         \"formatted_address\" : \"Poland\",\n" +
      "         \"geometry\" : {\n" +
      "            \"bounds\" : {\n" +
      "               \"northeast\" : {\n" +
      "                  \"lat\" : 54.9054761,\n" +
      "                  \"lng\" : 24.1458931\n" +
      "               },\n" +
      "               \"southwest\" : {\n" +
      "                  \"lat\" : 49.002025,\n" +
      "                  \"lng\" : 14.1228641\n" +
      "               }\n" +
      "            },\n" +
      "            \"location\" : {\n" +
      "               \"lat\" : 51.919438,\n" +
      "               \"lng\" : 19.145136\n" +
      "            },\n" +
      "            \"location_type\" : \"APPROXIMATE\",\n" +
      "            \"viewport\" : {\n" +
      "               \"northeast\" : {\n" +
      "                  \"lat\" : 54.9054761,\n" +
      "                  \"lng\" : 24.1458931\n" +
      "               },\n" +
      "               \"southwest\" : {\n" +
      "                  \"lat\" : 49.002025,\n" +
      "                  \"lng\" : 14.1228641\n" +
      "               }\n" +
      "            }\n" +
      "         },\n" +
      "         \"place_id\" : \"ChIJuwtkpGSZAEcR6lXMScpzdQk\",\n" +
      "         \"types\" : [ \"country\", \"political\" ]\n" +
      "      },\n" +
      "      {\n" +
      "         \"address_components\" : [\n" +
      "            {\n" +
      "               \"long_name\" : \"2X6P+R8\",\n" +
      "               \"short_name\" : \"2X6P+R8\",\n" +
      "               \"types\" : [ \"plus_code\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Tuchla-Osada\",\n" +
      "               \"short_name\" : \"Tuchla-Osada\",\n" +
      "               \"types\" : [ \"locality\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Jarosław County\",\n" +
      "               \"short_name\" : \"Jarosław County\",\n" +
      "               \"types\" : [ \"administrative_area_level_2\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Podkarpackie Voivodeship\",\n" +
      "               \"short_name\" : \"Podkarpackie Voivodeship\",\n" +
      "               \"types\" : [ \"administrative_area_level_1\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"Poland\",\n" +
      "               \"short_name\" : \"PL\",\n" +
      "               \"types\" : [ \"country\", \"political\" ]\n" +
      "            },\n" +
      "            {\n" +
      "               \"long_name\" : \"37-545\",\n" +
      "               \"short_name\" : \"37-545\",\n" +
      "               \"types\" : [ \"postal_code\" ]\n" +
      "            }\n" +
      "         ],\n" +
      "         \"formatted_address\" : \"2X6P+R8 Tuchla-Osada, Poland\",\n" +
      "         \"geometry\" : {\n" +
      "            \"bounds\" : {\n" +
      "               \"northeast\" : {\n" +
      "                  \"lat\" : 50.012125,\n" +
      "                  \"lng\" : 22.985875\n" +
      "               },\n" +
      "               \"southwest\" : {\n" +
      "                  \"lat\" : 50.012,\n" +
      "                  \"lng\" : 22.98575\n" +
      "               }\n" +
      "            },\n" +
      "            \"location\" : {\n" +
      "               \"lat\" : 50.0121,\n" +
      "               \"lng\" : 22.985842\n" +
      "            },\n" +
      "            \"location_type\" : \"ROOFTOP\",\n" +
      "            \"viewport\" : {\n" +
      "               \"northeast\" : {\n" +
      "                  \"lat\" : 50.0134114802915,\n" +
      "                  \"lng\" : 22.9871614802915\n" +
      "               },\n" +
      "               \"southwest\" : {\n" +
      "                  \"lat\" : 50.0107135197085,\n" +
      "                  \"lng\" : 22.9844635197085\n" +
      "               }\n" +
      "            }\n" +
      "         },\n" +
      "         \"place_id\" : \"GhIJCyQofowBSUAR8gUtJGD8NkA\",\n" +
      "         \"plus_code\" : {\n" +
      "            \"compound_code\" : \"2X6P+R8 Tuchla-Osada, Poland\",\n" +
      "            \"global_code\" : \"9G242X6P+R8\"\n" +
      "         },\n" +
      "         \"types\" : [ \"plus_code\" ]\n" +
      "      }\n" +
      "   ],\n" +
      "   \"status\" : \"OK\"\n" +
      "}\n"
}
