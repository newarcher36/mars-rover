package com.wallapop.utils;

import java.util.Scanner;

public final class Utils {
	
	private Utils() {}
	
	public static final void printMessage(String msg) {
		System.out.println(msg);
	    System.out.flush();
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
