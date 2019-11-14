package com.nasa.marsrover.domain.service;

import com.nasa.marsrover.domain.exception.ObstacleException;
import com.nasa.marsrover.domain.model.planet.Obstacle;
import com.nasa.marsrover.domain.model.planet.PlanetMap;
import com.nasa.marsrover.domain.model.planet.Position;
import com.nasa.marsrover.domain.model.rover.CommandParserService;
import com.nasa.marsrover.domain.model.rover.ParserService;
import com.nasa.marsrover.domain.model.rover.Rover;
import com.nasa.marsrover.domain.model.rover.commands.Command;
import com.nasa.marsrover.domain.values.MapSettings;
import com.nasa.marsrover.domain.values.Orders;
import com.nasa.marsrover.domain.values.RoverCoordinates;

import javax.inject.Named;
import java.util.List;

@Named
public class MarsRoverService implements RoverService {

    private Rover marsRover;
    private final ParserService commandParserService;

    public MarsRoverService(CommandParserService parser) {
        commandParserService = parser;
        marsRover = new Rover();
    }

    @Override
    public PlanetMap createMap(MapSettings settings) {
        PlanetMap planetMap = new PlanetMap(settings.getSizeX(), settings.getSizeY());

        RoverCoordinates roverCoordinates = settings.getRoverCoordinates();
        Position roverPosition = planetMap.getPosition(roverCoordinates.getX(), roverCoordinates.getY());

        roverPosition.setRover(marsRover);
        marsRover.setStartPoint(settings.getRoverCoordinates());

        settings.getObstacleCoordinates()
                .forEach(coordinate -> {
                    planetMap
                            .getPosition(coordinate.getX(), coordinate.getY())
                            .setObstacle(new Obstacle());
                });

        return planetMap;
    }

    @Override
    public RoverCoordinates moveRover(Orders orders) throws ObstacleException {
        marsRover.go(getCommands(orders));
        return marsRover.getRoverInfo();
    }

    private List<Command> getCommands(Orders orders) {
        return commandParserService.parse(orders.getOrders());
    }
}
