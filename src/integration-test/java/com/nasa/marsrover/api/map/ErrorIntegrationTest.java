package com.nasa.marsrover.api.map;

import com.nasa.marsrover.domain.values.Coordinates;
import com.nasa.marsrover.domain.values.Direction;
import com.nasa.marsrover.domain.values.MapSettings;
import com.nasa.marsrover.domain.values.RoverCoordinates;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

class ErrorIntegrationTest extends AbstractIntegrationTest {

    @Test
    void handle_illegal_argument_exception() {
        given()
                .contentType(APPLICATION_JSON_VALUE)
                .body(aMapSettingsWithMissingMapSize())
                .when()
                .post("/mars/map")
                .then()
                .statusCode(HTTP_BAD_REQUEST)
                .extract().statusCode();
    }

    private MapSettings aMapSettingsWithMissingMapSize() {
        return new MapSettings(5, 5, Set.of(new Coordinates(3,2)), new RoverCoordinates(2,2, Direction.NORTH));
    }
}