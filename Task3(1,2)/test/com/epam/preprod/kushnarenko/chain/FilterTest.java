package com.epam.preprod.kushnarenko.chain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

public class FilterTest {

	File f;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Before
	public void initial() {
		f = new File("text.txt");
	}

	@Test
	public void testFormat() {
		Filter ff = new FormatFilter(null, "txt");
		assertTrue(ff.match(f));
	}

	@Test
	public void testFormatFalse() {
		Filter ff = new FormatFilter(null, "pdf");
		assertFalse(ff.match(f));
	}

	@Test
	public void testName() {
		Filter ff = new NameFilter(null, "text");
		assertTrue(ff.match(f));
	}

	@Test
	public void testNameFalse() {
		Filter ff = new NameFilter(null, "1");
		assertFalse(ff.match(f));
	}

	@Test
	public void testDate() {
		Filter ff = null;
		try {
			ff = new DateFilter(null, sdf.parse("30/09/2015"), sdf.parse("30/10/2015"));
		} catch (ParseException e) {
		}
		assertTrue(ff.match(f));
	}

	@Test
	public void testDateFalse() {
		Filter ff = null;
		try {
			ff = new DateFilter(null, sdf.parse("30/08/2015"), sdf.parse("30/09/2015"));
		} catch (ParseException e) {
		}
		assertFalse(ff.match(f));
	}

	@Test
	public void testSize() {
		Filter ff = new SizeFilter(null, new Long(20), new Long(30));
		assertTrue(ff.match(f));
	}
	
	@Test
	public void testSizeFalse() {
		Filter ff = new SizeFilter(null, new Long(30), new Long(40));
		assertFalse(ff.match(f));
	}

}
