package com.nasa.marsrover.api.map;

import com.nasa.marsrover.domain.values.Coordinates;
import com.nasa.marsrover.domain.values.Direction;
import com.nasa.marsrover.domain.values.MapSettings;
import com.nasa.marsrover.domain.values.RoverCoordinates;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

class MarsMapIntegrationTest extends AbstractIntegrationTest {

    @Test void
    create_mars_map_given_a_defined_settings() {
        given()
                .contentType(APPLICATION_JSON_VALUE)
                .body(aMapSettings())
                .when()
                .post("/mars/map")
                .then()
                .statusCode(HTTP_OK)
                .extract()
                .statusCode();
    }

    private MapSettings aMapSettings() {
        return new MapSettings(5, 5, Set.of(new Coordinates(3,2)), new RoverCoordinates(2,2, Direction.NORTH));
    }
}
