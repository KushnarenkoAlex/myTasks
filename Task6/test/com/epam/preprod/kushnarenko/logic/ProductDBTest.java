package com.epam.preprod.kushnarenko.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductDBTest {

	private ProductDB db;

	@Before
	public void init() {
		db = new ProductDB();
	}

	@Test
	public void testGetByIdException() {
		assertEquals(null, db.getById(-1));
	}

	@Test
	public void testSize() {
		assertEquals(10, db.size());
	}

}
