package com.epam.preprod.kushnarenko.commands;

import java.util.Date;

import com.epam.preprod.kushnarenko.logic.Shop;
import com.epam.preprod.kushnarenko.util.ConsoleWorker;

public class BuyBucketCommand implements Command {

	@Override
	public void execute(ConsoleWorker cw) {
		Shop shop = Shop.getInstance();
		Date d = cw.getDate();
		cw.buyBucket(shop.buyBucket(d));
		cw.printBucket(shop);
		shop.clearBucket();
	}

}
