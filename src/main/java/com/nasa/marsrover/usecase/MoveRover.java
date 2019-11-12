package com.nasa.marsrover.usecase;

import com.nasa.marsrover.domain.exception.InvalidCommandException;
import com.nasa.marsrover.domain.exception.ObstacleException;
import com.nasa.marsrover.domain.service.RoverService;
import com.nasa.marsrover.domain.values.Orders;
import com.nasa.marsrover.domain.values.RoverCoordinates;

import javax.inject.Named;

@Named
public class MoveRover {

    private final RoverService roverService;

    public MoveRover(RoverService roverService) {
        this.roverService = roverService;
    }

    public RoverCoordinates execute(Orders orders) throws ObstacleException, InvalidCommandException {
        return roverService.moveRover(orders);
    }
}
