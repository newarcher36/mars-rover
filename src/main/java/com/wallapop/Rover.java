package com.wallapop;

public class Rover {

	private Orientation orientation;
	private Position position;

	public void setOrientation(Orientation north) {
		this.orientation = north;
	}

	public NavigationConsole getNavigationConsole() {
		return null;
	}

	public void go() {
		
	}

	public Position getCurrentPosition() {
		return position;
	}
}
