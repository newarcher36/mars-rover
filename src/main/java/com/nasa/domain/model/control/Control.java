package com.nasa.domain.model.control;

public abstract class Control {
		
   public final void init() {
		setMap();
		setRover();
		setObstacles();
		driveRover();
	}
	
	protected abstract void setMap();
	
	protected abstract void setRover();
	
	protected abstract void setObstacles();
	
	protected abstract void driveRover();
	
	protected abstract void printMissionInfo();
}
