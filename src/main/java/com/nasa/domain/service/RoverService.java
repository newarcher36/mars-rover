package com.nasa.domain.service;

import com.nasa.domain.exception.InvalidCommandException;
import com.nasa.domain.exception.ObstacleException;
import com.nasa.domain.model.rover.Rover;
import com.nasa.domain.values.Orders;
import com.nasa.domain.values.RoverCoordinates;

public interface RoverService {
    RoverCoordinates moveRover(Orders coordinates) throws ObstacleException, InvalidCommandException;

    Rover getRover();
}
