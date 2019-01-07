package com.wallapop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MarsRoverTest {

	@Test
	public void move_rover_forward() throws Exception {

		Planet marsMap = new Planet(16, 18);
		Position roverPosition = marsMap.getPosition(2, 1);

		Rover rover = new Rover();
		rover.getNavigationConsole().setDirection(Direction.SOUTH);
		rover.getNavigationConsole().setCommands(Arrays.asList('f','f','f'));
		rover.setPosition(roverPosition);
		
		roverPosition.setRover(rover);
				
		rover.go();
		
		assertEquals(Direction.SOUTH, rover.getNavigationConsole().getDirection());
		assertEquals(marsMap.getPosition(5, 1),rover.getPosition());
	}

	@Test
	public void move_rover_backward() throws Exception {
		Planet marsMap = new Planet(16, 18);
		Position roverPosition = marsMap.getPosition(4, 2);

		Rover rover = new Rover();
		rover.getNavigationConsole().setDirection(Direction.WEST);
		rover.getNavigationConsole().setCommands(Arrays.asList('b','b','b'));
		rover.setPosition(roverPosition);
		
		roverPosition.setRover(rover);
		
		rover.go();

		assertEquals(Direction.WEST, rover.getNavigationConsole().getDirection());
		assertEquals(marsMap.getPosition(4, 5),rover.getPosition());
	}

	@Test
	public void turn_rover_right() throws Exception {
		
		Planet marsMap = new Planet(10, 7);
		Position roverPosition = marsMap.getPosition(3, 7);

		Rover rover = new Rover();
		rover.getNavigationConsole().setDirection(Direction.WEST);
		rover.getNavigationConsole().setCommands(Arrays.asList('r'));
		rover.setPosition(roverPosition);
		
		roverPosition.setRover(rover);
		
		rover.go();
		assertEquals(Direction.NORTH, rover.getNavigationConsole().getDirection());
		
		rover.getNavigationConsole().setCommands(Arrays.asList('r'));
		rover.go();
		assertEquals(Direction.EAST, rover.getNavigationConsole().getDirection());
		
		rover.getNavigationConsole().setCommands(Arrays.asList('r'));
		rover.go();
		assertEquals(Direction.SOUTH, rover.getNavigationConsole().getDirection());
		
		rover.getNavigationConsole().setCommands(Arrays.asList('r'));
		rover.go();
		assertEquals(Direction.WEST, rover.getNavigationConsole().getDirection());		
		
		assertEquals(marsMap.getPosition(3, 7),rover.getPosition());
	}

	@Test
	public void turn_rover_left() throws InvalidCommandException {
		Planet marsMap = new Planet(10, 7);
		Position roverPosition = marsMap.getPosition(3, 7);

		Rover rover = new Rover();
		rover.getNavigationConsole().setDirection(Direction.NORTH);
		rover.getNavigationConsole().setCommands(Arrays.asList('l'));
		rover.setPosition(roverPosition);
		
		roverPosition.setRover(rover);
		
		rover.go();
		assertEquals(Direction.WEST, rover.getNavigationConsole().getDirection());
		
		rover.getNavigationConsole().setCommands(Arrays.asList('l'));
		rover.go();
		assertEquals(Direction.SOUTH, rover.getNavigationConsole().getDirection());
		
		rover.getNavigationConsole().setCommands(Arrays.asList('l'));
		rover.go();
		assertEquals(Direction.EAST, rover.getNavigationConsole().getDirection());
		
		rover.getNavigationConsole().setCommands(Arrays.asList('l'));
		rover.go();
		assertEquals(Direction.NORTH, rover.getNavigationConsole().getDirection());
		
		assertEquals(marsMap.getPosition(3, 7),rover.getPosition());
	}
	
	@Test
	public void test_wrapped_edges_north_and_south() throws Exception {
		
		Planet marsMap = new Planet(12, 14);
		Position roverPosition = marsMap.getPosition(1, 8);

		Rover rover = new Rover();
		rover.getNavigationConsole().setDirection(Direction.NORTH);
		rover.getNavigationConsole().setCommands(Arrays.asList('f','f','f','f'));
		rover.setPosition(roverPosition);
		
		roverPosition.setRover(rover);		
		rover.go();		
		
		assertEquals(Direction.NORTH, rover.getNavigationConsole().getDirection());
		assertEquals(marsMap.getPosition(9, 8), rover.getPosition());
		
		rover.getNavigationConsole().setCommands(Arrays.asList('b','b','b','b'));
		rover.go();
		
		assertEquals(Direction.NORTH, rover.getNavigationConsole().getDirection());
		assertEquals(marsMap.getPosition(1, 8), rover.getPosition());
		
	}
	
	@Test
	public void test_wrapped_edges_east_and_west() throws Exception {
		
		Planet marsMap = new Planet(12, 14);
		Position roverPosition = marsMap.getPosition(6, 12);

		Rover rover = new Rover();
		rover.getNavigationConsole().setDirection(Direction.EAST);
		rover.getNavigationConsole().setCommands(Arrays.asList('f','f','f','f'));
		rover.setPosition(roverPosition);
		
		roverPosition.setRover(rover);
		rover.go();		
		
		assertEquals(Direction.EAST, rover.getNavigationConsole().getDirection());
		assertEquals(marsMap.getPosition(6, 2), rover.getPosition());
		
		
		rover.getNavigationConsole().setCommands(Arrays.asList('b','b','b','b'));
		rover.go();
		
		assertEquals(Direction.EAST, rover.getNavigationConsole().getDirection());
		assertEquals(marsMap.getPosition(6, 12), rover.getPosition());
	} 
}