package com.epam.preprod.kushnarenko.commands;

import com.epam.preprod.kushnarenko.logic.Shop;
import com.epam.preprod.kushnarenko.util.ConsoleWorker;

public class PrintInfoCommand implements Command {

	@Override
	public void execute(Shop shop, ConsoleWorker cw) {
		cw.printInfo();
	}

}
