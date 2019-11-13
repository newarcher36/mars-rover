package com.nasa.marsrover.domain.exception;

public class ObstacleException extends RuntimeException {

	private static final long serialVersionUID = -3906826060776828570L;
	
	public ObstacleException(String msg) {
		super(msg);
	}
}
