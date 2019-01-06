package com.wallapop;

public class Planet {
		
	private Position[][] positions;
	private int sizeX;
	private int sizeY;

	public Planet(int sizeX, int sizeY) {
		this.sizeX =  sizeX;
		this.sizeY = sizeY;
		this.positions = createMap(sizeX,sizeY);
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
	
	public Position[][] createMap(int sizeX, int sizeY) {
		
		positions = new Position[sizeX][sizeY];
		int[][] moves = {
	            {-1, 0},
	            { 0, 1},
	            { 1, 0},
	            { 0,-1}
	        };
		
		for (int row = 0; row < sizeX; row++) {
			for (int col = 0; col < sizeY; col ++) {
				positions[row][col] = new Position();
			}
		}
		
		int destintyRow = 0;
		int destinyCol = 0;
		Direction direction;
		Position position;
		
		for (int row = 0; row < sizeX; row++) {
			for (int col = 0; col < sizeY; col ++) {
				position = getPosition(row,col);				
				for (Orientation orientation : Orientation.values()) {
					destintyRow = row + moves[orientation.getValue()][0];
					destinyCol = col + moves[orientation.getValue()][1];					
					direction = new Direction(getPosition(destintyRow,destinyCol));
					position.setDirection(direction,orientation.getValue());					
				}
			}
		}
		
		return positions;
	}
	
	@Override
    public String toString() {
		
		String map = "";
		
		for (int row = 0; row < sizeX; row++) {						
			for (int col = 0; col < sizeY; col++) {				
				map += "|";
				if (positions[row][col].getRover() != null) {
					map += positions[row][col].toString();
					continue;
				}				
				map += "_";
			}
			
			map +="|\n";
		}
		
		return map;
		
	}
}
