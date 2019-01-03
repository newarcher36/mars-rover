package com.wallapop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MarsRoverTest {
	
	@Test
	public void move_rover_forward() throws InvalidCommandException {
		
		int sizeX = 6;
		int sizeY = 8;
		
		Planet marsMap = initializeMap(sizeX,sizeY);
		
		Rover rover = new Rover();
		rover.setOrientation(Orientation.NORTH);
		
		int posX = 6;
		int posY = 6;
		marsMap.setPosition(posX,posY,rover);
		
		List<String> commands = Arrays.asList("");
		
	    rover.getNavigationConsole().setCommands(commands);
		rover.go();
	    
		assertEquals(rover.getCurrentPosition().getId(),36);
	}

	@Test
	public void move_rover_backward() {
		
	}
	
	@Test
	public void turn_rover_right() {
		
	}
	
	@Test
	public void turn_rover_left() {
		
	}
	
	private Planet initializeMap(int sizeX, int sizeY) {
		return null;
	}
}