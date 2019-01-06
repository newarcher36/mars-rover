package com.wallapop;

import java.util.List;

public class Rover {

	private Direction direction;
	private Position currentPosition;
	private NavigationConsole navigationConsole = new NavigationConsole();

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public NavigationConsole getNavigationConsole() {
		return this.navigationConsole;
	}

	public void go() {
		
		List<String> commands = navigationConsole.getCommands();
		
		commands.forEach( command -> {
			
			switch(command) {
				case Commands.FORWARD:
					moveRover();
					break;
				case Commands.BACKWARD:
					if (direction.equals(Direction.NORTH)) {
						setDirection(Direction.SOUTH);
					} else if (direction.equals(Direction.EAST)) {
						setDirection(Direction.WEST);
					} else if (direction.equals(Direction.WEST)) {
						setDirection(Direction.EAST);
					} else {
						setDirection(Direction.NORTH);
					}
					moveRover();
					break;
				case Commands.RIGHT:
					break;
				case Commands.LEFT:
					default:
			}			
			});
	}

	public Position getCurrentPosition() {
		return this.currentPosition;
	}

	public void setPosition(Position position) {
		this.currentPosition = position;
	}
	
	@Override
    public String toString() {
		return "#";
	}
	
	public void moveRover() {
		this.currentPosition.setRover(null);
		setPosition(currentPosition.getNextPosition(direction));
		this.currentPosition.setRover(this);
	}
}
