package com.nasa.domain.service;

import com.nasa.domain.exception.InvalidCommandException;
import com.nasa.domain.exception.ObstacleException;
import com.nasa.domain.model.planet.Position;
import com.nasa.domain.model.rover.MarsRover;
import com.nasa.domain.model.rover.Rover;
import com.nasa.domain.values.Orders;
import com.nasa.domain.values.RoverCoordinates;

import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class MarsRoverService implements RoverService {

    private Rover marsRover = new MarsRover();

    @Override
    public RoverCoordinates moveRover(Orders orders) throws ObstacleException, InvalidCommandException {
        marsRover.getNavigationConsole().setCommands(getChars(orders.getOrders()));
        marsRover.go();
        Position roverPosition = marsRover.getPosition();
        return new RoverCoordinates(roverPosition.getX(),roverPosition.getY(),marsRover.getNavigationConsole().getDirection());
    }

    @Override
    public Rover getRover() {
        return marsRover;
    }

    private List<Character> getChars(String command) {
        return command.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }
}
