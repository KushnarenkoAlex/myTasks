package com.epam.preprod.kushnarenko.commands;

import com.epam.preprod.kushnarenko.logic.ConsoleWorker;
import com.epam.preprod.kushnarenko.logic.Shop;

public class ExitCommand implements Command {

	@Override
	public void execute(Shop shop, ConsoleWorker cw) {
		System.exit(0);
	}

}
