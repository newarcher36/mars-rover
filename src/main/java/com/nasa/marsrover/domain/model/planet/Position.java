package com.nasa.marsrover.domain.model.planet;

import com.nasa.marsrover.domain.model.rover.Rover;
import com.nasa.marsrover.domain.values.Direction;

public class Position {

    private Rover rover;
    private Position[] positionsAround = new Position[4];
    private Obstacle obstacle;
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        verify();
    }

    public Rover getRover() {
        return this.rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public Position getNextPosition(Direction direction) {
        return positionsAround[direction.getValue()];
    }

    void setPositionAround(Position position, int direction) {
        this.positionsAround[direction] = position;
    }

    public boolean hasObstacle() {
        return obstacle != null;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        String position = "";

        if (rover != null) {
            position = rover.toString();
        } else if (obstacle != null) {
            position = obstacle.toString();
        }

        return position;
    }

    private void verify() {
        String errorMessage = "Coordinate [%s] cannot be less than 0";

        if (x < 0) {
            throw new IllegalArgumentException(String.format(errorMessage, "x"));
        }

        if (y < 0) {
            throw new IllegalArgumentException(String.format(errorMessage, "y"));
        }
    }
}
