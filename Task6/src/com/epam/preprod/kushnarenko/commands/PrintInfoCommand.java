package com.epam.preprod.kushnarenko.commands;

import com.epam.preprod.kushnarenko.util.ConsoleWorker;

public class PrintInfoCommand implements Command {

	@Override
	public void execute(ConsoleWorker cw) {
		cw.printInfo();
	}

}
