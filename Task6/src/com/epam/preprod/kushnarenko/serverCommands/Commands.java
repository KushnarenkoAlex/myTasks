package com.epam.preprod.kushnarenko.serverCommands;

import java.util.HashMap;

public class Commands {

	private static HashMap<String, ServerCommand> commands;

	static {
		commands = new HashMap<>();
		commands.put("get count", new GetCountCommand());
		commands.put("get item", new GetItemCommand());
		commands.put("count", new GetCountCommand());
		commands.put("get_info", new GetItemCommand());
		commands.put("no_command", new NoCommand());
	}

	public static ServerCommand get(String commandName) {
		if (!commands.containsKey(commandName)||commandName==null) {
			return commands.get("no_command");
		}
		return commands.get(commandName);
	}

}
