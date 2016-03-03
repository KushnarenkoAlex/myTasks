package com.epam.preprod.kushnarenko.serverCommands;

import com.epam.preprod.kushnarenko.logic.Shop;
import com.epam.preprod.kushnarenko.util.Const;

public class NoCommand implements ServerCommand {

	@Override
	public String execute(String s, String protocol) {
		return Const.NO_COMMAND;
	}
	
	@Override
	public Shop getShopInstance() {
		return null;
	}

}
