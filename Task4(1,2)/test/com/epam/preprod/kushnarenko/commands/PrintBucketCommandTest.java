package com.epam.preprod.kushnarenko.commands;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.epam.preprod.kushnarenko.logic.Shop;
import com.epam.preprod.kushnarenko.util.ConsoleWorker;

public class PrintBucketCommandTest {

	Command c;

	@Before
	public void initialize() {
		c = new PrintBucketCommand();
	}

	@Test
	public void executeTest() {
		Shop shop = new Shop();
		ConsoleWorker cw = new ConsoleWorker();
		PrintStream originalOut = System.out;
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		c.execute(shop, cw);
		System.setOut(originalOut);
		assertEquals(3, os.toString().split("\n").length);
	}

}
