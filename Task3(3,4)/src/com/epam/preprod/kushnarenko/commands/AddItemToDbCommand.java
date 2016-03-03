package com.epam.preprod.kushnarenko.commands;

import com.epam.preprod.kushnarenko.entity.Product;
import com.epam.preprod.kushnarenko.logic.ConsoleWorker;
import com.epam.preprod.kushnarenko.logic.Shop;

public class AddItemToDbCommand implements Command {

	@Override
	public void execute(Shop shop, ConsoleWorker cw) {
		String className = cw.getProductName();
		Product product = cw.getProduct(className);
		shop.addToDB(product);
	}

}
