package com.epam.preprod.kushnarenko.serverCommands;

import com.epam.preprod.kushnarenko.logic.Shop;

public interface ServerCommand {

	public String execute(String s, String protocol);

	Shop getShopInstance();
}
