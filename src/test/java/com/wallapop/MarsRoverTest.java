package com.wallapop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MarsRoverTest {

	@Test
	public void move_rover_forward() throws InvalidCommandException {

		Planet marsMap = new Planet(6, 8);

		Rover rover = new Rover();
		rover.setOrientation(Orientation.SOUTH);

		Position roverPosition = marsMap.getPosition(2, 1);
		roverPosition.setRover(rover);
		rover.setPosition(roverPosition);

		List<String> commands = Arrays.asList("f");

		rover.getNavigationConsole().setCommands(commands);
		rover.go();

		assertEquals(rover.getCurrentPosition(), marsMap.getPosition(3, 1));
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
}