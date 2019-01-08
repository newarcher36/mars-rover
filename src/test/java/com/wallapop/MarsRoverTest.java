package com.wallapop;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.wallapop.exception.InvalidCommandException;
import com.wallapop.planet.Mars;
import com.wallapop.planet.Obstacle;
import com.wallapop.planet.Position;
import com.wallapop.rover.Console;
import com.wallapop.rover.MarsRover;
import com.wallapop.values.Direction;

public class MarsRoverTest {
	
	@Test
	public void test_map_creation() {
		int sizeX = 16;
		int sizeY = 18;
		
		Mars marsMap = new Mars(sizeX, sizeY);
		Position[][] positions = marsMap.getArrayPositions();
		
		assertEquals(sizeX,positions.length);
		assertEquals(sizeY,positions[0].length);
		
		for (int x = 0; x < sizeX; x++) {
			for (int y = 0; y < sizeY; y++) {
				Position position = marsMap.getPosition(x, y);
				assertNotNull(position);
			}
		}
	}

	@Test
	public void move_rover_forward() throws Exception {

		Mars marsMap = new Mars(16, 18);
		Position roverPosition = marsMap.getPosition(2, 1);

		MarsRover rover = new MarsRover();
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
		Mars marsMap = new Mars(16, 18);
		Position roverPosition = marsMap.getPosition(4, 2);

		MarsRover rover = new MarsRover();
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
		
		Mars marsMap = new Mars(10, 7);
		Position roverPosition = marsMap.getPosition(3, 7);

		MarsRover rover = new MarsRover();
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
		Mars marsMap = new Mars(10, 7);
		Position roverPosition = marsMap.getPosition(3, 7);

		MarsRover rover = new MarsRover();
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
		
		Mars marsMap = new Mars(12, 14);
		Position roverPosition = marsMap.getPosition(1, 8);

		MarsRover rover = new MarsRover();
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
		
		Mars marsMap = new Mars(12, 14);
		Position roverPosition = marsMap.getPosition(6, 12);

		MarsRover rover = new MarsRover();
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
	
	@Test
	public void invalid_command_characters() throws Exception {				
		Console navigationConsole = new MarsRover().getNavigationConsole();
		List<Character> commands = Arrays.asList('f','b','k');
		
		assertThrows(InvalidCommandException.class,() -> navigationConsole.setCommands(commands),"Invalid command: k");
	}
	
	@Test
	public void rover_detects_obstacles() throws Exception {
		
		Mars marsMap = new Mars(16, 14);
		Position obstaclePosition = marsMap.getPosition(5, 12);
		obstaclePosition.setObstacle(new Obstacle(obstaclePosition));		

		MarsRover rover = new MarsRover();
		rover.getNavigationConsole().setDirection(Direction.EAST);
		rover.getNavigationConsole().setCommands(Arrays.asList('f','l','f','r','f'));
		
		Position roverPosition = marsMap.getPosition(6, 10);
		rover.setPosition(roverPosition);
		
		roverPosition.setRover(rover);		
		rover.go();
		
		assertTrue(rover.isObstacleDetected());
		assertEquals(marsMap.getPosition(5, 11),rover.getPosition());
	}
	
	@Test
	public void rover_full_trek_in_mars() {
		
	}
	
	@Test
	public void test_render_map() {
		
	}
}