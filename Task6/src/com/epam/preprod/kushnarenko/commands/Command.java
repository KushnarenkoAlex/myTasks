package com.epam.preprod.kushnarenko.commands;

import com.epam.preprod.kushnarenko.util.ConsoleWorker;

public interface Command {
	public void execute(ConsoleWorker cw);
}
