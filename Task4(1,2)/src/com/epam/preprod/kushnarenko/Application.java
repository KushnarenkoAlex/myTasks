package com.epam.preprod.kushnarenko;

import java.util.HashMap;

import com.epam.preprod.kushnarenko.commands.*;
import com.epam.preprod.kushnarenko.logic.Shop;
import com.epam.preprod.kushnarenko.util.ConsoleWorker;

public class Application {

	private Shop shop;

	private ConsoleWorker cw;

	private HashMap<String, Command> commands;

	{
		shop = new Shop();
		commands = new HashMap<String, Command>();
		cw = new ConsoleWorker();
		initCommands();
	}

	private void initCommands() {
		commands.put("0", new PrintInfoCommand());
		commands.put("1", new PrintListCommand());
		commands.put("2", new PrintBucketCommand());
		commands.put("3", new PrintFiveItemsCommand());
		commands.put("4", new AddItemToBucketCommand());
		commands.put("5", new ClearBucketCommand());
		commands.put("6", new BuyBucketCommand());
		commands.put("7", new ExitCommand());
		commands.put("8", new ReturnSubListCommand());
		commands.put("9", new AddItemToDbCommand());
	}

	private void executeCommand(String string) {
		Command c = commands.get(string);
		try {
			c.execute(shop, cw);
		} catch (Exception e) {
			cw.wrongCommand();
		}
	}

	private void run() {
		cw.printInfo();
		while (true) {
			executeCommand(cw.getCommand());
		}
	}

	public static void main(String[] args) {
		Application a = new Application();
		a.run();
	}
}
