package com.nasa.planet;

import com.nasa.values.Direction;

public abstract class Planet {
		
	private Position[][] positions;
	private int sizeX;
	private int sizeY;

	public Planet(int sizeX, int sizeY) {
		this.sizeX =  sizeX;
		this.sizeY = sizeY;
		createMapGrid(sizeX, sizeY);
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
	
	public Position[][] getArrayPositions(){
		return this.positions;
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
		String simbol = "";
		
		for (int row = 0; row < sizeX; row++) {						
			for (int col = 0; col < sizeY; col++) {				
				map.append("|");
				simbol = positions[row][col].toString(); 
				if(!simbol.isEmpty()) {
					map.append(simbol);
					continue;
				}				
				map.append("_");
			}			
			map.append("|\n");
		}
		
		return map.toString();
	}
}