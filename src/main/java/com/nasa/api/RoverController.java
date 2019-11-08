package com.nasa.api;

import com.nasa.domain.exception.InvalidCommandException;
import com.nasa.domain.exception.ObstacleException;
import com.nasa.domain.values.Orders;
import com.nasa.domain.values.RoverCoordinates;
import com.nasa.usecase.MoveRover;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mars")
public class RoverController {
    private final MoveRover moveRover;

    public RoverController(MoveRover moveRover) {
        this.moveRover = moveRover;
    }

    @PostMapping(value = "/rover", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RoverCoordinates driveRover(@RequestBody Orders orders) throws ObstacleException, InvalidCommandException {
        return moveRover.execute(orders);
    }
}
