package com.epam.preprod.kushnarenko.commands;

import com.epam.preprod.kushnarenko.logic.ConsoleWorker;
import com.epam.preprod.kushnarenko.logic.Shop;

public interface Command {
	public void execute(Shop shop, ConsoleWorker cw);
}
