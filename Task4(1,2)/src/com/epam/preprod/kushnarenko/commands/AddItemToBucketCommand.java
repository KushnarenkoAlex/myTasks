package com.epam.preprod.kushnarenko.commands;

import com.epam.preprod.kushnarenko.logic.Shop;
import com.epam.preprod.kushnarenko.util.ConsoleWorker;

public class AddItemToBucketCommand implements Command {

	@Override
	public void execute(Shop shop, ConsoleWorker cw) {
		int id = cw.getId();
		int quantity = cw.getQuantity();
		shop.addItem(id, quantity);
	}

}
