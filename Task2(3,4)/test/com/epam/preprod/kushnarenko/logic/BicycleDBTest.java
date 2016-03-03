package com.epam.preprod.kushnarenko.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BicycleDBTest {

	private BicycleDB db;

	@Before
	public void init() {
		db = new BicycleDB();
	}

	@Test
	public void testGetByIdException() {
		assertEquals(null, db.getById(-1));
	}

	@Test
	public void testGetById() {
		assertEquals(db.getById(1), db.getById(1));
	}

	@Test
	public void testSize() {
		assertEquals(10, db.size());
	}

}
