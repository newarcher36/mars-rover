package com.wallapop;

import java.util.List;

public class Rover {

	private Orientation orientation;
	private Position currentPosition;
	private NavigationConsole navigationConsole = new NavigationConsole();

	public void setOrientation(Orientation north) {
		this.orientation = north;
	}

	public NavigationConsole getNavigationConsole() {
		return this.navigationConsole;
	}

	public void go() {
		
		List<String> commands = navigationConsole.getCommands();
		
		commands.forEach( command -> {
			
			switch(command) {
				case Commands.FORWARD:
					this.currentPosition.setRover(null);
					setPosition(currentPosition.getDirection(orientation).getNextPosition());
					this.currentPosition.setRover(this);
					break;
				case Commands.BACKWARD:
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
}
