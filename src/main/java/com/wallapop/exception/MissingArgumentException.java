package com.wallapop.exception;

public class MissingArgumentException extends Exception {

	private static final long serialVersionUID = -4273761734146219109L;

	public MissingArgumentException(String msg) {
		super(msg);		
	}
}
