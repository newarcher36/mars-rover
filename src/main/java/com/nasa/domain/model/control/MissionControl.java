package com.nasa.domain.model.control;

import com.nasa.domain.model.planet.Obstacle;
import com.nasa.domain.model.planet.PlanetMap;
import com.nasa.domain.model.planet.Position;
import com.nasa.domain.model.rover.MarsRover;
import com.nasa.domain.model.rover.Rover;
import com.nasa.domain.utils.Utils;
import com.nasa.domain.values.Direction;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MissionControl extends Control {

	private static final String BANNER_FILE = "/banner.txt";
	private static String welcomeMessage;
	private Scanner reader = new Scanner(System.in);
	private PlanetMap marsPlanetMap;
	private Rover marsRover;

	static {

		InputStream is = MissionControl.class.getResourceAsStream(BANNER_FILE);
		welcomeMessage = new BufferedReader(new InputStreamReader(is)).lines().parallel()
				.collect(Collectors.joining("\n"));

		Utils.printMessage(welcomeMessage);

	}

	@Override
	public void setMap() {
		int sizeX = Utils.getIntegerInput(reader, "Insert horizontal map size:");
		int sizeY = Utils.getIntegerInput(reader, "Insert vertical map size:");
		//this.marsPlanetMap = new PlanetMap(sizeX, sizeY);
	}

	@Override
	public void setRover() {
		int roverx = Utils.getIntegerInput(reader, "Insert horizontal initial rover position:");
		int rovery = Utils.getIntegerInput(reader, "Insert vertical initial rover position:");

		this.marsRover = new MarsRover();
		Position roverPosition = marsPlanetMap.getPosition(roverx, rovery);
		roverPosition.setRover(marsRover);

		this.marsRover.setPosition(roverPosition);

		String message = "Insert initial rover direction (0 = north, 1 = east, 2 = south, 3 = west.";
		int directionValue;
		Direction direction;

		do {
			directionValue = Utils.getIntegerInput(reader, message);
			direction = Direction.getDirectionByValue(directionValue);
		} while (direction == null);

		marsRover.getNavigationConsole().setDirection(direction);
	}

	@Override
	public void setObstacles() {
		int obstaclesNumber = Utils.getIntegerInput(reader, "Insert number of obstacles:");
		int x;
		int y;
		Position obstaclePosition;

		for (int i = 0; i < obstaclesNumber; i++) {
			Utils.printMessage("Obstacle " + (i + 1));
			x = Utils.getIntegerInput(reader, "Insert coordinate x:");
			y = Utils.getIntegerInput(reader, "Insert coordinate y:");
			obstaclePosition = marsPlanetMap.getPosition(x, y);
			obstaclePosition.setObstacle(new Obstacle());
		}
	}

	@Override
	public void driveRover() {

		String msgInsert = "Insert command (f = forward, b = backward, l = turn left, r = turn right, q = quit).\n"
				+ "You can insert several commands such as \"bfrrlff\"";
		String command;

		do {
			printMissionInfo();
			command = Utils.getStringInput(reader, msgInsert);

			if (command.equals("q")) {
				Utils.printMessage("Bye!!!");
				break;
			}
			Utils.printMessage("\033[H\033[2J");

			try {
				marsRover.getNavigationConsole().setCommands(getChars(command));
				marsRover.go();
			} catch (Exception exception) {
				Utils.printMessage(exception.getMessage());
			}
		} while (true);
	}

	@Override
	protected void printMissionInfo() {
		int roverx;
		int rovery;
		Direction direction;
		roverx = marsRover.getPosition().getX();
		rovery = marsRover.getPosition().getY();
		direction = marsRover.getNavigationConsole().getDirection();

		Utils.printMessage(marsPlanetMap + "\n");
		Utils.printMessage((String.format("Rover is at x:%d y:%d facing:%s", roverx, rovery, direction)));

	}

	private List<Character> getChars(String command) {
		return command.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
	}
}