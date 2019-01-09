package com.wallapop.utils;

import java.util.Scanner;

import com.wallapop.exception.MissingArgumentException;

public final class Utils {
	
	public static final void notNull(Object obj,String msg) throws MissingArgumentException {
		if(obj == null)
			throw new MissingArgumentException(msg);
	}
	
	public static final void printMessage(Object msg) {
		System.out.println(msg);
	}
	
	public static int getIntegerInput(Scanner reader,String msg) {
    	printMessage(msg);
    	return reader.nextInt();
    }
	
	public static String getStringInput(Scanner reader,String msg) {
    	printMessage(msg);
    	return reader.next();
    }
}
