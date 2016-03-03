package com.epam.preprod.kushnarenko.util;

import java.lang.reflect.Array;
import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import com.epam.preprod.kushnarenko.entity.Bicycle;
import com.epam.preprod.kushnarenko.strategy.FilterIterator;

public class MyArrayList<E extends Bicycle> implements List<E> {

	private Bicycle[] container;
	private int size;
	private int capacity;
	public static final int DEFAULT_SIZE = 10;

	public MyArrayList() {
		capacity = DEFAULT_SIZE;
		container = new Bicycle[capacity];
		size = 0;
	}

	private void increaseCapacity() {
		capacity += DEFAULT_SIZE;
		container = Arrays.copyOf(container, capacity);

	}

	private boolean indexIsCorrect(int index) {
		if (index < 0 || index > size) {
			return false;
		}
		return true;
	}

	@Override
	public boolean add(E e) {
		if (size >= capacity) {
			this.increaseCapacity();
		}
		container[size++] = (Bicycle) e;
		return true;
	}

	@Override
	public void add(int index, Object element) {
		if (!indexIsCorrect(index)) {
			throw new IndexOutOfBoundsException();
		}
		if (size >= capacity) {
			this.increaseCapacity();
		}
		for (int i = size; i >= index; i--) {
			container[i + 1] = container[i];
		}
		size++;
		container[index] = (Bicycle) element;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		if (!indexIsCorrect(index)) {
			throw new IndexOutOfBoundsException();
		}
		if (c.isEmpty()) {
			return false;
		}
		while (true) {
			if ((size + c.size()) < capacity) {
				break;
			}
			increaseCapacity();
		}
		for (int i = size - 1; i >= index; i--) {
			container[i + c.size()] = container[i];
		}
		int i = index;
		for (Object e : c) {
			container[i] = (Bicycle) e;
			i += 1;
		}
		size += c.size();
		return true;
	}

	@Override
	public boolean addAll(Collection c) {
		if (c.isEmpty()) {
			return false;
		}
		for (Object e : c) {
			this.add(e);
		}
		return true;
	}

	@Override
	public E get(int index) {
		if (!indexIsCorrect(index)) {
			throw new IndexOutOfBoundsException();
		}
		return (E) container[index];
	}

	@Override
	public boolean remove(Object o) {
		for (int i = 0; i < size; i++)
			if (container[i].equals(o)) {
				remove(i);
				return true;
			}
		return false;
	}

	@Override
	public Object remove(int index) {
		if (!indexIsCorrect(index)) {
			throw new IndexOutOfBoundsException();
		}
		Object element = container[index];
		for (int i = index; i < size; i++) {
			container[i] = container[i + 1];
		}
		size--;
		return element;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iteratorr(null);
	}

	public Iterator<E> iterator(FilterIterator fi) {
		return new Iteratorr(fi);
	}

	private class Iteratorr implements Iterator<E> {

		int index = 0;
		int previous = -1;
		FilterIterator fi;

		public Iteratorr(FilterIterator f) {
			fi = f;
		}

		@Override
		public boolean hasNext() {
			if (!fi.equals(null)) {
				while (++Iteratorr.this.index < MyArrayList.this.size && !fi.correct(container[Iteratorr.this.index]))
					;
			} else {
				Iteratorr.this.index++;
			}
			return index < size;

		}

		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return container[index++];
		}

		@Override
		public void remove() {

		}

	}

	@Override
	public void clear() {
		capacity = DEFAULT_SIZE;
		container = (Bicycle[]) new Object[capacity];
		size = 0;
	}

	@Override
	public boolean contains(Object o) {
		int i = 0;
		while (i < size) {
			if (container[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	public boolean contasinsAll(Collection<?> c) {
		for (Object e : c) {
			if (!contains(e)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int indexOf(Object o) {
		int index = -1;
		for (int i = 0; i < container.length; i++) {
			if (container[i].equals(o)) {
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = -1;
		for (int i = 0; i < container.length; i++) {
			if (container[i].equals(o)) {
				index = i;
			}
		}
		return index;
	}

	@Override
	public ListIterator<E> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection c) {
		if (c.isEmpty()) {
			return false;
		}
		for (Object o : c) {
			remove(o);
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection c) {
		return false;
	}

	@Override
	public Object set(int index, Object element) {
		if (!indexIsCorrect(index)) {
			throw new IndexOutOfBoundsException();
		}
		Object e = container[index];
		container[index] = (Bicycle) element;
		return e;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<Object> subList(int fromIndex, int toIndex) {
		if (!indexIsCorrect(fromIndex) || !indexIsCorrect(toIndex) || toIndex < fromIndex) {
			throw new IndexOutOfBoundsException();
		}
		List<Object> mal = new MyArrayList<>();
		for (int i = fromIndex; i < toIndex; i++) {
			mal.add(container[i]);
		}
		return mal;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		int i = 0;
		while (i < size) {
			array[i] = container[i++];
		}
		return array;
	}

	public <Object> Object[] toArray(Object[] a) {
		if (a.length < size) {
			a = (Object[]) Array.newInstance(a.getClass().getComponentType(), size);
		} else if (a.length > size) {
			a[size] = null;
		}
		int i = 0;
		for (Bicycle e : container) {
			a[i++] = e;
		}
		return a;
	}

	public static void main(String[] args) {
		// MyArrayList<String> s = new MyArrayList<>();
		// s.add("String1");
		// s.add("String2");
		// s.add("String3");
		// s.add(1, "asdf");
		// s.add("NEW");
		// s.addAll(0, s);
		// System.out.println("TEST");
		// Iterator<String> i = s.iterator();
		// while (i.hasNext()) {
		// System.out.println(i.next());
		// }
		// System.out.println("TOARRAY");
		// Object array[] = new Object[s.size];
		// array = s.toArray();
		// for (Object m : array) {
		// System.out.println(m);
		// }
		// ArrayList<Object> al=new ArrayList<>();
		// al.iterator()
	}

}
