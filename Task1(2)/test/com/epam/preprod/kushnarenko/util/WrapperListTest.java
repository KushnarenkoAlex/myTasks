package com.epam.preprod.kushnarenko.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class WrapperListTest {

	WrapperList<Object> wl;

	@Before
	public void init() {
		List<Object> u = new ArrayList<>();
		for (int i = 97; i < 107; i++) {
			u.add((char) i);
		}
		List<Object> m = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			m.add(i);
		}
		wl = new WrapperList<Object>(u, m);
		// System.out.println(wl);

	}

	public void initEmpty() {
		List<Object> u = new ArrayList<>();
		List<Object> m = new ArrayList<>();
		wl = new WrapperList<Object>(u, m);
	}

	@Test
	public void testSize() {
		assertEquals(20, wl.size());
	}

	@Test
	public void testIsEmpty() {
		initEmpty();
		assertTrue(wl.isEmpty());
	}

	@Test
	public void testIsEmptyFalse() {
		assertFalse(wl.isEmpty());
	}

	@Test
	public void testContainsMod() {
		assertTrue(wl.contains(1));
	}

	@Test
	public void testContainsUn() {
		assertTrue(wl.contains('a'));
	}

	@Test
	public void testContainsUnFalse() {
		assertFalse(wl.contains('z'));
	}

	@Test
	public void testIterator() {
		int i = 0;
		Iterator<Object> it = wl.iterator();
		while (it.hasNext()) {
			i++;
			it.next();
		}
		assertEquals(i, wl.size());
	}

	@Test
	public void testToArray() {
		Object[] obj = wl.toArray();
		assertEquals(wl.size(), obj.length);
	}

	@Test
	public void testToArrayTArray() {
		Object[] obj = new Object[30];
		wl.toArray(obj);

	}

	@Test
	public void testAddE() {
		int i = wl.size();
		wl.add(100);
		assertEquals(i + 1, wl.size());
	}

	@Test
	public void testToString() {
		wl.toString();
	}

	@Test
	public void testRemoveObject() {

	}

	@Test
	public void testContainsAll() {
		assertTrue(wl.containsAll(wl));
	}

	@Test
	public void testContainsAllFalse() {
		List<Object> l = new LinkedList<>();
		l.add(1);
		l.add('z');
		assertFalse(wl.containsAll(l));
	}

	@Test
	public void testAddAllCollectionOfQextendsE() {
		int size = wl.size();
		wl.addAll(wl);
		assertEquals(size * 2, wl.size());

	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddAllIntCollectionOfQextendsException() {
		wl.addAll(0, wl);
	}

	@Test
	public void testAddAllIntCollectionOfQextendsE() {
		wl.addAll(12, wl);
	}

	@Test
	public void testRemoveAll() {
		List<Object> l = new LinkedList<>();
		int size = wl.size();
		l.add(1);
		l.add('z');
		wl.removeAll(l);
		assertEquals(size - 1, wl.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testClear() {
		wl.clear();
	}

	@Test
	public void testGet() {
		assertEquals('a', wl.get(0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSet() {
		wl.set(0, 'd');
	}

	@Test
	public void testAddIntE() {
		int size = wl.size();
		wl.add(15, 6);
		assertEquals(size + 1, wl.size());

	}

	@Test
	public void testRemoveInt() {
		int size = wl.size();
		wl.remove(15);
		assertEquals(size - 1, wl.size());
	}

	@Test
	public void testIndexOf() {
		assertEquals(0, wl.indexOf('a'));
	}

	@Test
	public void testLastIndexOf() {
		assertEquals(0, wl.lastIndexOf('a'));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testListIterator() {
		wl.listIterator();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testListIteratorInt() {
		wl.listIterator(5);
	}

	@Test
	public void testSubList() {
		List<Object> list = wl.subList(0, 15);
		assertEquals(15, list.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRetainAllExc() {
		List<Object> l = new LinkedList<>();
		l.add(1);
		l.add(2);
		wl.retainAll(l);
	}

	@Test
	public void testRetainAll() {
		List<Object> l = new LinkedList<>();
		for (int i = 97; i < 107; i++) {
			l.add((char) i);
		}
		wl.retainAll(l);
		System.out.println(wl);
	}

}
