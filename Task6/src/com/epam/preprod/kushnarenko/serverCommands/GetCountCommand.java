package com.epam.preprod.kushnarenko.serverCommands;

import java.util.Formatter;

import com.epam.preprod.kushnarenko.logic.Shop;
import com.epam.preprod.kushnarenko.util.Const;

public class GetCountCommand implements ServerCommand {

	@SuppressWarnings("resource")
	@Override
	public String execute(String s, String protocol) {
		String res = "";
		if (protocol.equals(Const.TCP)) {
			res = Const.COUNT_TCP;
		} else {
			res = Const.COUNT_JSON;
		}
		Shop shop = getShopInstance();
		Formatter f = new Formatter();
		f.format(res, shop.getCount());
		return f.toString();
		}

	@Override
	public Shop getShopInstance() {
		return Shop.getInstance();
	}

}
