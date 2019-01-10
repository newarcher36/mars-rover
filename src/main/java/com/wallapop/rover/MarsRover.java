package com.wallapop.rover;

import java.util.ListIterator;

import com.wallapop.planet.Position;
import com.wallapop.rover.command.Command;
import com.wallapop.rover.console.Console;
import com.wallapop.rover.console.NavigationConsole;
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
	
	@Override
	public void move(Position nextPosition) {
		
		detectObstacle(nextPosition);
		
		if (isObstacleDetected()) {
			navigationConsole.setMessage("Obstacle detected! Rover has stopped.").print();
			return;
		}
		
		this.currentPosition.setRover(null);
		setPosition(nextPosition);
		this.currentPosition.setRover(this);
	}
	
	@Override
	public void detectObstacle(Position nextPosition) {
		if (nextPosition.getObstacle() != null)
			this.obstacleDetected = true;		
	}
	
	@Override
	public void move(Direction direction) {		
		navigationConsole.setDirection(direction);		
	}
	
	@Override
	public void go() {		
		
		ListIterator<Command> iterator = navigationConsole.getCommands().listIterator();									
		Command command;
		
		if (isObstacleDetected()) {
			rearmRover();
		}		
		
		while (iterator.hasNext() && !isObstacleDetected()) {
			command = iterator.next();
			command.execute(this);
		}			
	}
	
	@Override
	public void rearmRover() {		
		obstacleDetected = false;
	}
	
	@Override
	public boolean isObstacleDetected() {
		return this.obstacleDetected;
	}

	@Override
    public String toString() {
		return "#";
	}
}
