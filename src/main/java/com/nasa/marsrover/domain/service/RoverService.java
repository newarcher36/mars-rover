package com.nasa.marsrover.domain.service;

import com.nasa.marsrover.domain.exception.InvalidCommandException;
import com.nasa.marsrover.domain.exception.ObstacleException;
import com.nasa.marsrover.domain.model.planet.PlanetMap;
import com.nasa.marsrover.domain.values.MapSettings;
import com.nasa.marsrover.domain.values.Orders;
import com.nasa.marsrover.domain.values.RoverCoordinates;

public interface RoverService {

    PlanetMap createMap(MapSettings mapSettings);

    RoverCoordinates moveRover(Orders coordinates) throws ObstacleException, InvalidCommandException;
}
