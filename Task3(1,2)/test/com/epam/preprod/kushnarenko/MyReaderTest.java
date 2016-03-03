package com.epam.preprod.kushnarenko;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class MyReaderTest {

	private MyReader mr;

	@Before
	public void init() {
		try {
			mr = new MyReader("text.txt");
		} catch (FileNotFoundException e) {
		}
	}

	@Test
	public void testIterator() {
		int i = 0;
		for (String s : mr) {
			i++;
		}
		assertEquals(4, i);
	}

}
