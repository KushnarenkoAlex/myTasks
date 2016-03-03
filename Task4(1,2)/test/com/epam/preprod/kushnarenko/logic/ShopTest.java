package com.epam.preprod.kushnarenko.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.zip.GZIPOutputStream;

import org.junit.Before;
import org.junit.Test;

import com.epam.preprod.kushnarenko.util.Const;

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

	public static void save(int n, Shop shop, String fileName) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
			for (int i = 0; i < n; i++) {
				oos.writeObject(shop.getDB());
			}
			oos.flush();
			oos.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	@Test
	public void comapreGZIPandSerialization() {
		String s = Const.TEST_FILE;
		int n = 100;
		save(n, shop, s);
		long ser = new File(s).length();
		System.out.println("SERIALIZATION: " + ser);
		String sGzip = Const.GZIP_FILE;
		saveGZIP(n, shop, sGzip);
		long zip = new File(sGzip).length();
		System.out.println("GZIP: " +zip);
		assertTrue(ser > zip);
	}

	public static void saveGZIP(int n, Shop shop, String fileName) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(fileName)));
			for (int i = 0; i < n; i++) {
				oos.writeObject(shop.getDB());
			}
			oos.flush();
			oos.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
