package com.epam.preprod.kushnarenko.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class WrapperList<E> implements List<E> {

	private List<E> unmodifiable, modifiable;
	private int border;

	public WrapperList(List<E> unmodifiable, List<E> modifiable) {
		this.unmodifiable = unmodifiable;
		this.modifiable = modifiable;
		border = unmodifiable.size();
	}

	private void checkIndex(int index) {
		System.out.println(border);
		if (index < border) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public int size() {
		return unmodifiable.size() + modifiable.size();
	}

	@Override
	public boolean isEmpty() {
		return unmodifiable.isEmpty() && modifiable.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return unmodifiable.contains(o) || modifiable.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return new Iter();
	}

	public class Iter implements Iterator<E> {

		Iterator<E> mod, unmod;
		int index;

		public Iter() {
			index = 0;
			this.mod = modifiable.iterator();
			this.unmod = unmodifiable.iterator();
		}

		@Override
		public boolean hasNext() {
			return mod.hasNext() || unmod.hasNext();
		}

		@Override
		public E next() {
			if (index < unmodifiable.size()) {
				index++;
				return unmod.next();
			}
			index++;
			return mod.next();
		}

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("WrapperList [");
		for (E e : this) {
			sb.append(e).append(", ");
		}
		return sb.append("]").toString();
	}

	@Override
	public Object[] toArray() {
		Object[] object = new Object[unmodifiable.size() + modifiable.size()];
		int i = 0;
		for (E e : this) {
			object[i++] = e;
		}
		return object;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if (a.length < unmodifiable.size() + modifiable.size()) {
			System.arraycopy(this.toArray(), 0, a, 0, a.length);
			return a;
		}
		System.arraycopy(this.toArray(), 0, a, 0, this.size());
		if (a.length > size()) {
			a[size()] = null;
		}
		return a;
	}

	@Override
	public boolean add(E e) {
		return modifiable.add(e);
	}

	@Override
	public boolean remove(Object o) {
		checkIndex(indexOf(o));
		return modifiable.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!(unmodifiable.contains(o)) && !(modifiable.contains(o))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return modifiable.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		checkIndex(index);
		return modifiable.addAll(index - unmodifiable.size(), c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		int size = this.size();
		for (Object o : c) {
			if (this.contains(o)) {
				this.remove(o);
			}
		}
		return size != this.size();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		for (E e : unmodifiable) {
			if (!c.contains(e)) {
				throw new IllegalArgumentException();
			}
		}
		return modifiable.retainAll(c);
	}

	@Override
	public void clear() {
		throw new IllegalArgumentException();
	}

	@Override
	public E get(int index) {
		return (index < border) ? unmodifiable.get(index) : modifiable.get(index - border);
	}

	@Override
	public E set(int index, E element) {
		checkIndex(index);
		return modifiable.set(index - modifiable.size(), element);
	}

	@Override
	public void add(int index, E element) {
		checkIndex(index);
		modifiable.add(index - unmodifiable.size(), element);
	}

	@Override
	public E remove(int index) {
		checkIndex(index);
		return modifiable.remove(index - unmodifiable.size());
	}

	@Override
	public int indexOf(Object o) {
		if (unmodifiable.contains(o)) {
			return unmodifiable.indexOf(o);
		}
		return modifiable.indexOf(o) + border;
	}

	@Override
	public int lastIndexOf(Object o) {
		if (modifiable.contains(o)) {
			return modifiable.lastIndexOf(o);
		}
		return unmodifiable.lastIndexOf(o);
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
	public List<E> subList(int fromIndex, int toIndex) {
		if (fromIndex < 0 && toIndex < 0 && fromIndex >= size() && toIndex >= size() && fromIndex > toIndex) {
			throw new IndexOutOfBoundsException();
		}
		List<E> ret = new LinkedList<>();
		for (int i = fromIndex; i < toIndex; i++) {
			ret.add(get(i));
		}
		return ret;
	}

}
