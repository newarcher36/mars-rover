package com.wallapop.rover;

import java.util.ListIterator;

import com.wallapop.planet.Position;
import com.wallapop.values.Command;
import com.wallapop.values.Direction;

public class MarsRover implements Rover {

	private Position currentPosition;
	private Console navigationConsole = new NavigationConsole();
	private boolean obstacleDetected = false;

	@Override
	public Console getNavigationConsole() {
		return this.navigationConsole;
	}

	@Override
	public Position getPosition() {
		return this.currentPosition;
	}

	@Override
	public void setPosition(Position position) {
		this.currentPosition = position;
	}
	
	private void detectAndMove(Direction direction) {
		Position nextPosition = currentPosition.getNextPosition(direction);
		this.obstacleDetected = detectObstacle(nextPosition);
		
		if (!obstacleDetected) 
			moveRover(nextPosition);
	}
	
	@Override
	public void moveRover(Position nextPosition) {		
		this.currentPosition.setRover(null);
		setPosition(nextPosition);
		this.currentPosition.setRover(this);
	}
	
	public boolean detectObstacle(Position nextPosition) {
		return (nextPosition.getObstacle() != null) ? true : false;
	}

	@Override
	public void turnRover(int directionValue) {
		if (directionValue < 0) {
			directionValue = Direction.WEST.getValue();
		} else if (directionValue == Direction.values().length) {
			directionValue = Direction.NORTH.getValue();
		}
		navigationConsole.setDirection(Direction.getDirectionByValue(directionValue));		
	}
	
	@Override
	public void go() {
		
		ListIterator<Command> iterator = navigationConsole.getCommands().listIterator();
		
		while (iterator.hasNext() && !isObstacleDetected()) {
			int currentDirectionValue;
			Command command = iterator.next();
			
			switch(command) {
				case FOREWARD:
					detectAndMove(navigationConsole.getDirection());
					break;
				case BACKWARD:
					detectAndMove(navigationConsole.getOppositeDirection());
					break;
				case RIGHT:
					currentDirectionValue = navigationConsole.getDirection().getValue();
					turnRover(++currentDirectionValue);
					break;
				case LEFT:
					currentDirectionValue = navigationConsole.getDirection().getValue();
					turnRover(--currentDirectionValue);
					break;
			}
		}		
	}
	
	public boolean isObstacleDetected() {
		return this.obstacleDetected;
	}

	@Override
    public String toString() {
		return "#";
	}
}
