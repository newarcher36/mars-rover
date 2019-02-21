package com.nasa;

import com.nasa.control.Control;
import com.nasa.control.MissionControl;

public class MarsRoverMain {

    public static void main(String[] args) {    	
    	Control missionControl = new MissionControl();
    	missionControl.init();
    }    
}
