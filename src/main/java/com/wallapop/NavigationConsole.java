package com.wallapop;

import java.util.List;

public class NavigationConsole {
	
	private List<String> commands;

	public void setCommands(List<String> commands) throws InvalidCommandException {
		this.commands = commands;
		computeCommands();
	}

	private void computeCommands() throws InvalidCommandException {
		
	}

	public List<String> getCommands() {
		return this.commands;
	}
}
