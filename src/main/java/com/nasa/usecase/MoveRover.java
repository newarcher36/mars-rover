package com.nasa.usecase;

import com.nasa.domain.exception.InvalidCommandException;
import com.nasa.domain.exception.ObstacleException;
import com.nasa.domain.service.RoverService;
import com.nasa.domain.values.Orders;
import com.nasa.domain.values.RoverCoordinates;

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
