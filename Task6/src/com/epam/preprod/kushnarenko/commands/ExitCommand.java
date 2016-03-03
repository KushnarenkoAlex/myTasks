package com.epam.preprod.kushnarenko.commands;

import com.epam.preprod.kushnarenko.logic.Shop;
import com.epam.preprod.kushnarenko.util.ConsoleWorker;

public class ExitCommand implements Command {

	@Override
	public void execute(ConsoleWorker cw) {
		Shop shop = Shop.getInstance();
		shop.save();
		System.exit(0);
	}

}
