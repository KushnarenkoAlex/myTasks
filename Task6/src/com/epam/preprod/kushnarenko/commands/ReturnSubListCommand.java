package com.epam.preprod.kushnarenko.commands;

import com.epam.preprod.kushnarenko.logic.Shop;
import com.epam.preprod.kushnarenko.util.ConsoleWorker;

public class ReturnSubListCommand implements Command {

	@Override
	public void execute(ConsoleWorker cw) {
		Shop shop = Shop.getInstance();
		cw.printSubList(shop);
	}

}
