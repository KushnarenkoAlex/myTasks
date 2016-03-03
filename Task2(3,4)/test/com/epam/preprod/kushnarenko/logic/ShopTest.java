package com.epam.preprod.kushnarenko.logic;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ShopTest {

	private Shop shop;

	@Before
	public void init() {
		shop = new Shop();
	}

	@Test
	public void testClearBucket() {
		shop.clearBucket();
		assertEquals(0, shop.getBucketMap().size());
	}

	@Test
	public void testGetDBSize() {
		assertEquals(10, shop.getDBSize());
	}

	@Test
	public void testBuyBucket() {
		assertEquals(0, shop.buyBucket(new Date()));
	}

	@Test
	public void testBuyBucket2() {
		shop.addItem(0, 1);
		assertEquals(500, shop.buyBucket(new Date()));
	}



}
