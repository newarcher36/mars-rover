package com.wallapop.utils;

import java.util.Scanner;
import java.util.logging.Logger;

import com.wallapop.exception.MissingArgumentException;

public final class Utils {
	
	private static Logger logger = Logger.getLogger("Mars Rover info: ");
	
	private Utils() {}
	
	public static final void notNull(Object obj,String msg) throws MissingArgumentException {
		if(obj == null)
			throw new MissingArgumentException(msg);
	}
	
	public static final void printMessage(String msg) {
		logger.info(msg);
	}
	
	public static int getIntegerInput(Scanner reader,String msg) {
		
		printMessage(msg);
		
		int value = 0;
		
		do {
			if (reader.hasNextInt()) {
				value = reader.nextInt();
				break;
			}
		} while(true);		    
    	
    	return value;
    }
	
	public static String getStringInput(Scanner reader,String msg) {
		
    	printMessage(msg);
		
		String value = "";
		
		do {
			if (reader.hasNext()) {
				value = reader.next();
				break;
			}
		} while(true);
    	
    	return value;
    }
}
