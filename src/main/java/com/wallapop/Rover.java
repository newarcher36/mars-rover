package com.wallapop;

public class Rover {

	private Position currentPosition;
	private NavigationConsole navigationConsole = new NavigationConsole();

	public NavigationConsole getNavigationConsole() {
		return this.navigationConsole;
	}

	public void go() {
		
		navigationConsole.getCommands().forEach( command -> {
			
			int currentDirectionValue;
			
			switch(command) {
				case FOREWARD:
					moveRover(navigationConsole.getDirection());
					break;
				case BACKWARD:
					moveRover(navigationConsole.getOppositeDirection());
					break;
				case RIGHT:
					currentDirectionValue = navigationConsole.getDirection().getValue();
					turnRover(++currentDirectionValue);
					break;
				case LEFT:
					currentDirectionValue = navigationConsole.getDirection().getValue();
					turnRover(--currentDirectionValue);
					default:
			}			
			});
	}

	public Position getPosition() {
		return this.currentPosition;
	}

	public void setPosition(Position position) {
		this.currentPosition = position;
	}
	
	public void moveRover(Direction direction) {
		this.currentPosition.setRover(null);
		setPosition(currentPosition.getNextPosition(direction));
		this.currentPosition.setRover(this);
	}
	
	public void turnRover(int directionValue) {
		if (directionValue < 0) {
			directionValue = Direction.WEST.getValue();
		} else if (directionValue == Direction.values().length) {
			directionValue = Direction.NORTH.getValue();
		}
		navigationConsole.setDirection(Direction.getDirectionByValue(directionValue));		
	}
	
	@Override
    public String toString() {
		return "#";
	}
}
