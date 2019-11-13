package com.nasa.marsrover.domain.exception;

public class InvalidCommandException extends RuntimeException {
	
	private static final long serialVersionUID = -8236306188789930535L;

	public InvalidCommandException(String message) {
		super(message);
	}
}
