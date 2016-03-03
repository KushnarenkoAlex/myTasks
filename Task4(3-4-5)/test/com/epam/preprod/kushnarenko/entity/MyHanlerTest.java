package com.epam.preprod.kushnarenko.entity;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class MyHanlerTest {

	IProduct p;
	Product test;

	@Before
	public void init() {
		test = new Product();
		test.setId(5);
		test.setPrice(new BigDecimal(5));
		p = test.getProxy();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testSet() {
		p.setId(5);
	}

	@Test
	public void testGet() {
		assertEquals(new Integer(5), p.getId());
	}

}
