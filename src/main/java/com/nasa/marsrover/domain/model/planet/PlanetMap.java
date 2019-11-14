package com.nasa.marsrover.domain.model.planet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nasa.marsrover.domain.values.Direction;

public class PlanetMap {
    @JsonProperty
	private Position[][] positions;

	@JsonProperty
	private int sizeX;
	@JsonProperty
	private int sizeY;

	public PlanetMap(int sizeX, int sizeY) {
		this.sizeX =  sizeX == 0 ? 3 :sizeX;
		this.sizeY = sizeY == 0 ? 3 : sizeY;
		verify();
		createMapGrid(this.sizeX, this.sizeY);
		linkGridPositions();
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

	private void verify() {
		String errorMessage = "Size [%s] cannot be less than 0";

		if (sizeX < 0) {
			throw new IllegalArgumentException(String.format(errorMessage, "x"));
		}

		if (sizeY < 0) {
			throw new IllegalArgumentException(String.format(errorMessage, "y"));
		}
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

		int nextPositionRow;
		int nextPositionCol;
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
