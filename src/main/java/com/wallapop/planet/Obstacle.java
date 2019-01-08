package com.wallapop.planet;

public class Obstacle {
	
	private Position position;
	
	public Obstacle(Position position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "X";
	}
}
