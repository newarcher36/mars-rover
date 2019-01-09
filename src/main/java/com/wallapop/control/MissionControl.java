package com.wallapop.control;

import java.io.IOException;
import java.util.Scanner;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.common.primitives.Chars;
import com.wallapop.exception.InvalidCommandException;
import com.wallapop.planet.Mars;
import com.wallapop.planet.Obstacle;
import com.wallapop.planet.Position;
import com.wallapop.rover.MarsRover;
import com.wallapop.rover.Rover;
import com.wallapop.utils.Utils;
import com.wallapop.values.Direction;

public class MissionControl extends Control {
	
	private static final String BANNER_FILE = "banner.txt";
	private static String welcomeMessage;
	private Scanner reader = new Scanner(System.in);
	private Mars marsMap;
	private Rover marsRover;	
	
	static {		
		try {
			welcomeMessage = Resources.toString(Resources.getResource(BANNER_FILE), Charsets.UTF_8);
			Utils.printMessage(welcomeMessage);
		} catch (IOException e) {
			Utils.printMessage(e);
		}
    }
		
	@Override
	public void setMap() {
		int sizeX = Utils.getIntegerInput(reader, "Insert horizontal map size:");
        int sizeY = Utils.getIntegerInput(reader, "Insert vertical map size:");
        this.marsMap = new Mars(sizeX, sizeY);
	}

	@Override
	public void setRover() {
		int roverx = Utils.getIntegerInput(reader, "Insert horizontal initial rover position:");                
        int rovery = Utils.getIntegerInput(reader, "Insert vertical initial rover position:");
        
        this.marsRover = new MarsRover();
        Position roverPosition = marsMap.getPosition(roverx, rovery);
        roverPosition.setRover(marsRover);       
        
        this.marsRover.setPosition(roverPosition);
        
        
        final String directions = "nesw";
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
            Utils.printMessage("Obstacle " + (i+1));
            x = Utils.getIntegerInput(reader, "Insert coordinate x:");            
            y = Utils.getIntegerInput(reader, "Insert coordinate y:");
            obstaclePosition = marsMap.getPosition(x, y); 
            obstaclePosition.setObstacle(new Obstacle(obstaclePosition));
        }
	}

	@Override
	public void driveRover() {
						
		String msgInsert = "Insert command (f = forward, b = backward, l = turn left, r = turn right, q = quit).\n" +
						    "You can insert several commands such as \"bfrrlff\"";
        String command;
        
        do {        	
        	printMissionInfo();
        	command = Utils.getStringInput(reader, msgInsert);
        	
        	if (command.equals("q")) {
        		break;
        	}
        	
        	try {        		
        		marsRover.getNavigationConsole().setCommands(Chars.asList(command.toCharArray()));
        		marsRover.go();
        	} catch (InvalidCommandException exception) {
        		Utils.printMessage(exception.getMessage());
        	}        	        	        	
        } while(true);        
	}

	@Override
	protected void printMissionInfo() {
		int roverx,rovery;
		Direction direction;
		roverx = marsRover.getPosition().getRow();
    	rovery = marsRover.getPosition().getCol();
    	direction = marsRover.getNavigationConsole().getDirection();
    	
    	Utils.printMessage(marsMap + "\n");
    	Utils.printMessage((String.format("Rover is at x:%d y:%d facing:%s",roverx,rovery,direction)));
    	
	}
}