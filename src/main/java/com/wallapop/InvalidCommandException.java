package com.wallapop;

public class InvalidCommandException extends Exception {
	
	private static final long serialVersionUID = -8236306188789930535L;

	public InvalidCommandException(String message) {
		super(message);
	}
}
