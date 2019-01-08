package com.wallapop.planet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.wallapop.utils.Utils;

public class MarsExplorer implements Explorer {
	
	private Scanner reader = new Scanner(System.in);
	private Mars marsMap; 

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
        String direction = Utils.getStringInput(reader, "Insert initial rover direction:");
	}

	@Override
	public void setObstacles() {
		int obstaclesNumber = Utils.getIntegerInput(reader, "Insert number of obstacles:");

        int x;
        int y;
        List<List<Integer>> obstacles = new ArrayList<List<Integer>>();
        for (int i = 0; i < obstaclesNumber; i++) {
            Utils.printMessage("Obstacle " + i);
            x = Utils.getIntegerInput(reader, "Insert coordinate x:");            
            y = Utils.getIntegerInput(reader, "Insert coordinate y:");            
            obstacles.add(Arrays.asList(x, y));
        }
	}

	@Override
	public void driveRover() {
		String msgInsert = "Insert command (f = forward, b = backward, l = turn left, r = turn right):";
        String command;
        while ((command = Utils.getStringInput(reader, msgInsert)) != "x") {
        	//System.out.println(String.format("Rover is at x:%d y:%d facing:%s", roverx, rovery, roverz));
        }
	}
}