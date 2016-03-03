package com.epam.preprod.kushnarenko.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;

import com.epam.preprod.kushnarenko.entity.Bicycle;
import com.epam.preprod.kushnarenko.entity.MountainBike;
import com.epam.preprod.kushnarenko.strategy.Filter;

public class BicycleListTest {

	private BicycleList<Bicycle> b;
	private Bicycle tempBike;

	{
		b = new BicycleList<>();
		tempBike = new MountainBike(1000, 2000, "sstteeeell", 200, 19999, "9NewModel", 10, "Hand", 20, true);
	}

	@Before
	public void addTen() {
		for (int i = 0; i < 10; i++) {
			b.add(new MountainBike(10, 10, "carbon", 100, 2005, Integer.toString(i), 10, "Hand", 20, true));

		}
	}

	@Test
	public void testAddE() {
		assertEquals(true, b.add(new MountainBike(16, 16, "aluminium", 100, 2013, "255", 10, "Hand", 20, true)));
	}

	@Test(expected = NullPointerException.class)
	public void testAddENull() {
		b.add(null);
	}

	@Test
	public void testAddIntE() {
		int bSize = b.size();
		b.add(4, new MountainBike(5, 5, "steall", 200, 1988, "RRecord", 10, "Hand", 20, true));
		b.add(4, new MountainBike(5, 5, "steall", 200, 1988, "RRecord", 10, "Hand", 20, true));
		assertEquals(bSize + 2, b.size());
	}

	@Test
	public void testUnmodifiedIterator() {
		int bSize = b.size();
		BicycleList<Bicycle> newB = new BicycleList<>();
		Iterator<Bicycle> i = b.iterator();
		b.remove(0);
		while (i.hasNext()) {
			newB.add(i.next());
		}
		assertEquals(bSize, newB.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddIntThrowIndexOutOfBoundsException() {
		b.add(-2, new MountainBike(5, 5, "steal", 200, 1988, "Record", 10, "Hand", 20, true));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddIntThrowIndexOutOfBoundsException2() {
		b.add(1000, new MountainBike(5, 5, "steal", 200, 1988, "Record", 10, "Hand", 20, true));
	}

	private ArrayList<Bicycle> createListOfBikes() {
		ArrayList<Bicycle> al = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			al.add(new MountainBike(10, 10, "aluminium" + i, 100, 2005, "Model" + Integer.toString(i), 10, "Hand", 20,
					true));
		}
		return al;
	}

	@Test
	public void testAddAllIntCollectionOfQextendsE() {
		assertEquals(true, b.addAll(0, createListOfBikes()));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddAllIntCollectionOfQextendsEIndexOutOfBoundsException() {
		assertEquals(false, b.addAll(-1, createListOfBikes()));
	}

	@Test
	public void testAddAllIntCollectionOfQextendsEIsEmpty() {
		assertEquals(false, b.addAll(1, new BicycleList<Bicycle>()));
	}

	@Test
	public void testAddAllCollectionOfQextendsE() {
		b.addAll(createListOfBikes());
	}

	@Test
	public void testAddAllCollectionOfQextendsEIsEmpty() {
		b.addAll(new BicycleList<Bicycle>());
	}

	@Test
	public void testGet() {
		b.get(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetIndexOutOfBoundsException() {
		b.get(-1);
	}

	@Test
	public void testRemoveObjectTrue() {
		assertTrue(b.remove(b.get(0)));
	}

	@Test
	public void test2RemoveObjectTrue() {
		int size = b.size();
		b.remove(b.get(1));
		assertEquals(size - 1, b.size());
	}

	@Test
	public void test2RemoveObjectFalse() {
		int size = b.size();
		assertFalse(b.remove(tempBike));
		assertEquals(size, b.size());
	}

	@Test
	public void testRemoveInt() {
		b.remove(2);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveIntIndexOutOfBoundsException() {
		b.get(-1);
	}

	@Test
	public void testIterator() {
		Iterator<Bicycle> i = b.iterator();
		int j = 0;
		while (i.hasNext()) {
			j++;
			i.next();
		}
		assertEquals(j, b.size());
	}

	@Test
	public void testFilterIterator() {
		b.set(3, new MountainBike(100, 100, "nocarbon", 10, 100, "MODEL", 10, "Hand", 20, true));
		Iterator<Bicycle> i = b.iterator(new Filter() {

			@Override
			public <E extends Bicycle> boolean correct(E container) {
				if ("carbon".equals(container.getFrameMaterial()))
					return true;
				return false;
			}
		});
		BicycleList<Bicycle> mal = new BicycleList<>();
		while (i.hasNext()) {
			mal.add(i.next());
		}
		assertEquals(9, mal.size());
	}

	@Test
	public void testClear() {
		b.clear();
		assertEquals(0, b.size());
	}

	@Test
	public void testSetIndexOutOfBoundsException() {
		assertEquals(b.get(0), b.set(0, tempBike));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testSet() {
		b.set(-1, new MountainBike(100, 200, "steel", 200, 1999, "NewModel", 10, "Hand", 20, true));
	}

	@Test
	public void testContainsTrue() {
		assertTrue(b.contains(b.get(0)));
	}

	@Test
	public void testContainsFalse() {
		assertFalse(b.contains(tempBike));
	}

	@Test
	public void testContainsAllFalse() {
		assertFalse(b.containsAll(createListOfBikes()));
	}

	private ArrayList<Bicycle> createListOfContainsBikes() {
		ArrayList<Bicycle> al = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			al.add(b.get(i));
		}
		return al;
	}

	@Test
	public void testContainsAllTrue() {
		assertTrue(b.containsAll(createListOfContainsBikes()));
	}

	@Test
	public void testIndexOf() {
		assertEquals(0, b.indexOf(b.get(0)));
	}

	@Test
	public void testIndexOfNull() {
		assertEquals(-1,
				b.indexOf(new MountainBike(1000, 2000, "sstteeeell", 200, 19999, "9NewModel", 10, "Hand", 20, true)));
	}

	@Test
	public void testIsEmptyTrue() {
		assertFalse(b.isEmpty());
	}

	@Test
	public void testIsEmptyFalse() {
		BicycleList<Bicycle> mal = new BicycleList<>();
		assertTrue(mal.isEmpty());
	}

	@Test
	public void testLastIndexOf() {
		assertEquals(0, b.lastIndexOf(b.get(0)));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testListIterator() {
		b.listIterator();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testListIntIterator() {
		b.listIterator(0);
	}

	@Test
	public void testToArray() {
		Object[] o = b.toArray();
		assertTrue(o.length == b.size());
	}

	@Test
	public void testToArray2() {
		BicycleList<Bicycle> newB = b;
		addTen();
		Object[] o = b.toArray();
		newB.toArray(o);
	}

	@Test
	public void testToArrayT() {
		Object[] o = b.toArray();
		b.toArray(o);
	}

	@Test
	public void test2ToArrayT() {
		Object[] o = b.subList(0, 2).toArray();
		b.toArray(o);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testSubList() {
		b.subList(3, 0);
	}

	@Test
	public void testRemoveAll() {
		assertTrue(b.removeAll(b.subList(0, 2)));
	}

	@Test
	public void testRemoveAllFalse() {
		assertFalse(b.removeAll(new ArrayList<Bicycle>()));
	}

	@Test
	public void testRetainAll() {
		BicycleList<Bicycle> bl = new BicycleList<>();
		bl.add(b.get(1));
		bl.add(b.get(2));
		b.retainAll(bl);
		assertEquals(bl.size(), b.size());

	}

	@Test
	public void testRetainAllNull() {
		BicycleList<Bicycle> bl = new BicycleList<>();
		assertFalse(b.retainAll(bl));
	}

	@Test
	public void testRetainAllFalse() {
		BicycleList<Bicycle> bl = new BicycleList<>();
		bl.add(tempBike);
		assertFalse(b.retainAll(bl));
	}
}
