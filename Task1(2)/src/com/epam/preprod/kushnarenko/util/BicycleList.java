package com.epam.preprod.kushnarenko.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import com.epam.preprod.kushnarenko.entity.Bicycle;
import com.epam.preprod.kushnarenko.strategy.Filter;

/**
 * BicycleList represents construction that allow to save {@link Bicycle}Bicycle
 * objects.
 *
 * @author Oleksandr Kushnarenko
 * @see List
 */
public class BicycleList<E extends Bicycle> implements List<E> {

	/**
	 * Array for saving data.
	 */
	private Bicycle[] container;
	/**
	 * Number of elements in the list.
	 */
	private int size;
	private int capacity;
	private ArrayList<Iter> iterators;
	/**
	 * Default initial capacity.
	 */
	public static final int DEFAULT_SIZE = 10;

	public BicycleList() {
		capacity = DEFAULT_SIZE;
		container = new Bicycle[capacity];
		size = 0;
		iterators = new ArrayList<>();
	}

	private void increaseCapacity() {
		capacity += DEFAULT_SIZE;
		container = Arrays.copyOf(container, capacity);

	}

	/**
	 * Checks if index is correct for BicycleList
	 * 
	 * @param index
	 *            index of element that is checked
	 */
	private boolean indexIsCorrect(int index) {
		if (index < 0 || index > size) {
			return false;
		}
		return true;
	}

	/**
	 * checks object for null pointer
	 * 
	 * @param e
	 *            cheked object
	 * @throws NullPointerException
	 *             if the specified object is null
	 */
	private void checkNullPointer(E e) {
		if (e == null)
			throw new NullPointerException();
	}

	@Override
	public boolean add(E e) {
		checkNullPointer(e);
		this.shot();
		if (size >= capacity) {
			this.increaseCapacity();
		}
		container[size++] = e;
		return true;
	}

	@Override
	public void add(int index, E element) {
		checkNullPointer(element);
		if (!indexIsCorrect(index)) {
			throw new IndexOutOfBoundsException();
		}
		this.shot();
		if (size >= capacity) {
			this.increaseCapacity();
		}
		for (int i = size; i >= index; i--) {
			container[i + 1] = container[i];
		}
		size++;
		container[index] = element;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		if (!indexIsCorrect(index)) {
			throw new IndexOutOfBoundsException();
		}
		if (c.isEmpty()) {
			return false;
		}
		this.shot();
		while (true) {
			if ((size + c.size()) < capacity) {
				break;
			}
			increaseCapacity();
		}
		Bicycle[] elements = Arrays.copyOfRange(container, index, size);
		int i = index;
		for (E e : c) {
			container[i++] = e;
		}
		for (int j = 0; j < elements.length; j++) {
			container[i + j] = elements[j];
		}
		size += c.size();
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		if (c.isEmpty()) {
			return false;
		}
		this.shot();
		for (E e : c) {
			this.add(e);
			for (int i = 0; i < size; i++) {
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if (!indexIsCorrect(index)) {
			throw new IndexOutOfBoundsException();
		}
		return (E) container[index];
	}

	@Override
	public boolean remove(Object o) {
		E e;
		try {
			e = remove(indexOf(o));
		} catch (IndexOutOfBoundsException exception) {
			return false;
		}
		return e != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		if (!indexIsCorrect(index)) {
			throw new IndexOutOfBoundsException();
		}
		this.shot();
		E element = (E) container[index];
		for (int i = index; i < size - 1; i++) {
			container[i] = container[i + 1];
		}
		size--;
		return element;
	}

	/**
	 * Using of this method meant that container will be change. It is a signal
	 * for iterators to make an actual snapshot.
	 **/
	private void shot() {
		for (Iter i : iterators) {
			i.snapshot();
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new Iter();
	}

	private class Iter implements Iterator<E> {

		int i = 0;
		int previous = -1;
		E[] snapshot;
		int size;

		public Iter() {
			size = size();
			iterators.add(this);
		}

		@SuppressWarnings("unchecked")
		void snapshot() {
			if (snapshot == null) {
				snapshot = (E[]) Arrays.copyOf(container, size);
			}
		}

		public boolean hasNext() {
			if (i >= size) {
				iterators.remove(this);
				return false;
			}
			return true;
		}

		public E next() {
			E next = snapshot == null ? get(i) : snapshot[i];
			previous = i++;
			return next;
		}

		public void remove() {
			if (previous == -1) {
				throw new IllegalStateException();
			}
			BicycleList.this.remove(previous);
			i = previous;
			previous = -1;
		}
	}

	public Iterator<E> iterator(Filter fi) {
		return new FilterIteratorr(fi);
	}

	/**
	 * FilterIterator returns only elements that match to the condition
	 * certained in method "correct" of {@link Filter}Filter interface
	 */
	private class FilterIteratorr implements Iterator<E> {

		int index = 0;
		int last;
		private boolean flag = false;
		private E next = null;
		Filter fi;

		public FilterIteratorr(Filter f) {
			fi = f;
			last = -1;
			FilterIteratorr.this.index = 0;
			findNext();
		}

		@SuppressWarnings("unchecked")
		private E findNext() {
			E temp = next;
			last = index;
			for (int i = index; i < size; i++) {
				if (fi.correct(container[i])) {
					index = i + 1;
					flag = true;
					next = (E) container[i];
					return temp;
				}
			}
			flag = false;
			return temp;
		}

		@Override
		public boolean hasNext() {
			return flag;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return findNext();
		}

		@Override
		public void remove() {
			if (last < 0) {
				throw new IllegalStateException();
			}
			BicycleList.this.remove(index);
			index = last;
			last = -1;
		}

	}

	@Override
	public void clear() {
		this.shot();
		capacity = DEFAULT_SIZE;
		container = new Bicycle[capacity];
		size = 0;
	}

	@Override
	public boolean contains(Object o) {
		int i = 0;
		while (i < size) {
			if (container[i].equals(o)) {
				return true;
			}
			i++;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
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
	public boolean removeAll(Collection<?> c) {
		if (c.isEmpty()) {
			return false;
		}
		for (Object o : c) {
			remove(o);
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		if (c.isEmpty()) {
			return false;
		}
		int num = 0;
		for (int i = size - 1; i >= 0; i--) {
			if (!c.contains(container[i])) {
				this.remove(i);
			} else {
				num++;
			}
		}
		if (num == 0) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, E element) {
		if (!indexIsCorrect(index)) {
			throw new IndexOutOfBoundsException();
		}
		this.shot();
		E e = (E) container[index];
		container[index] = element;
		return e;
	}

	@Override
	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		if (!indexIsCorrect(fromIndex) || !indexIsCorrect(toIndex) || toIndex < fromIndex) {
			throw new IndexOutOfBoundsException();
		}
		List<E> mal = new BicycleList<>();
		for (int i = fromIndex; i < toIndex; i++) {
			mal.add((E) container[i]);
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

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		if (a.length <= size) {
			return (T[]) Arrays.copyOf(container, size, a.getClass());
		}
		System.arraycopy(container, 0, a, 0, size);
		if (a.length > size) {
			a[size] = null;
		}
		return a;
	}
}
