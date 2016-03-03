package com.epam.preprod.kushnarenko.serverCommands;

import java.util.Formatter;

import com.epam.preprod.kushnarenko.entity.Product;
import com.epam.preprod.kushnarenko.logic.Shop;
import com.epam.preprod.kushnarenko.util.Const;

public class GetItemCommand implements ServerCommand {

	@Override
	public String execute(String s, String protocol) {
		String res = "";
		if (protocol.equals(Const.TCP)) {
			res = Const.ITEM_INFO_TCP;
		} else {
			res = Const.ITEM_INFO_JSON;
		}
		Shop shop = getShopInstance();
		Product p = shop.getItem(Integer.parseInt(s));
		@SuppressWarnings("resource")
		Formatter f = new Formatter();
		f.format(res, p.getId(), p.getPrice().toString());
		return f.toString();
	}
	
	@Override
	public Shop getShopInstance() {
		return Shop.getInstance();
	}

}
