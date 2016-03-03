package com.epam.preprod.kushnarenko.entity;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class MapHanlerTest {

	IProduct test;

	@Before
	public void init() {
		test = (IProduct) Proxy.newProxyInstance(IProduct.class.getClassLoader(), new Class[] { IProduct.class },
				new MapHanler());
	}

	@Test
	public void testSetGetId() {
		test.setId(5);
		assertEquals(new Integer(5), test.getId());
	}

	@Test
	public void testSetGetPrice() {
		test.setPrice(new BigDecimal(5));
		assertEquals(new BigDecimal(5), test.getPrice());
	}
	
}
