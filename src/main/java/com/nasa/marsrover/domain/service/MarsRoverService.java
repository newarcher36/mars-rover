package com.nasa.marsrover.domain.service;

import com.nasa.marsrover.domain.exception.ObstacleException;
import com.nasa.marsrover.domain.model.rover.Rover;
import com.nasa.marsrover.domain.values.Orders;
import com.nasa.marsrover.domain.values.RoverCoordinates;

import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class MarsRoverService implements RoverService {

    private Rover marsRover = new Rover(null);

    @Override
    public RoverCoordinates moveRover(Orders orders) throws ObstacleException {
        marsRover.go(orders.getOrders());
        return marsRover.getRoverInfo();
    }

    @Override
    public Rover getRover() {
        return marsRover;
    }

    private List<Character> getChars(String command) {
        return command.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }
}
