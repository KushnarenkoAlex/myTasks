package com.epam.preprod.kushnarenko.commands;

import com.epam.preprod.kushnarenko.entity.Product;
import com.epam.preprod.kushnarenko.logic.Shop;
import com.epam.preprod.kushnarenko.util.ConsoleWorker;

public class AddItemToDbCommand implements Command {

	@Override
	public void execute(ConsoleWorker cw) {
		Shop shop = Shop.getInstance();
		String className = cw.getProductName();
		Product product = cw.getProduct(className);
		shop.addToDB(product);
	}

}
