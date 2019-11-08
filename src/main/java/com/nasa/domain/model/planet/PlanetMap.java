package com.nasa.domain.model.planet;

import com.nasa.domain.model.rover.Rover;
import com.nasa.domain.values.Coordinates;
import com.nasa.domain.values.Direction;
import com.nasa.domain.values.RoverCoordinates;

import java.util.Set;

public class PlanetMap {
		
	private Position[][] positions;
	private int sizeX;
	private int sizeY;

	public PlanetMap(Coordinates coordinates) {
		this.sizeX =  coordinates.getX();
		this.sizeY = coordinates.getY();
		createMapGrid(sizeX, sizeY);
		linkGridPositions();
	}

	public void setRover(RoverCoordinates coordinates, Rover rover) {
		positions[coordinates.getX()][coordinates.getY()].setRover(rover);
	}

	public void setObstacles(Set<Coordinates> obstaclesCoordinates) {
		obstaclesCoordinates.forEach(
				coordinates -> positions[coordinates.getX()][coordinates.getY()].setObstacle(new Obstacle()));
	}

	public Position getPosition(int x, int y) {

		if (x >= sizeX) {
			x = x % sizeX;
		}

		if (x < 0) {
			x = sizeX - 1;
		}

		if (y >= sizeY) {
			y = y % sizeY;
		}

		if (y < 0) {
			y = sizeY - 1;
		}

		return this.positions[x][y];
	}

	private void createMapGrid(int sizeX, int sizeY) {
		this.positions = new Position[sizeX][sizeY];

		for (int row = 0; row < sizeX; row++) {
			for (int col = 0; col < sizeY; col ++) {
				this.positions[row][col] = new Position(row,col);
			}
		}
	}

	private void linkGridPositions() {

		int[][] moves = {
	            {-1, 0},
	            { 0, 1},
	            { 1, 0},
	            { 0,-1}
	        };

		int nextPositionRow = 0;
		int nextPositionCol = 0;
		Position position;

		for (int row = 0; row < sizeX; row++) {
			for (int col = 0; col < sizeY; col ++) {
				position = positions[row][col];
				for (Direction direction : Direction.values()) {
					nextPositionRow = row + moves[direction.getValue()][0];
					nextPositionCol = col + moves[direction.getValue()][1];
					position.setPositionAround(getPosition(nextPositionRow,nextPositionCol), direction.getValue());
				}
			}
		}
	}

	@Override
    public String toString() {

		StringBuilder map = new StringBuilder();
		String symbol;

		for (int row = 0; row < sizeX; row++) {
			for (int col = 0; col < sizeY; col++) {
				map.append("|");
				symbol = positions[row][col].toString();
				if(!symbol.isEmpty()) {
					map.append(symbol);
					continue;
				}
				map.append("_");
			}
			map.append("|\n");
		}

		return map.toString();
	}
}
