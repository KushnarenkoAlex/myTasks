package com.epam.preprod.kushnarenko.logic;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import com.epam.preprod.kushnarenko.entity.Product;

public class Cash {

	private LinkedHashMap<Integer, Product> goodsCash;

	private static Integer MAX_NUMBER = 5;

	/**
	 * Method removeEldestEntry allows to store only 5 last bought items.
	 * 
	 * @author Oleksandr_Kushnarenko
	 *
	 */
	public Cash() {
		goodsCash = new LinkedHashMap<Integer, Product>() {

			private static final long serialVersionUID = 7566466907258679826L;

			protected boolean removeEldestEntry(Map.Entry<Integer, Product> eldest) {
				return size() > MAX_NUMBER;
			}
		};
	}

	public void add(Product b) {
		goodsCash.put(b.getId(), b);
	}

	public Collection<Product> getCollection() {
		LinkedList<Product> ll = new LinkedList<>();
		for (Entry<Integer, Product> entry : goodsCash.entrySet()) {
			ll.add(entry.getValue());
		}
		return Collections.unmodifiableCollection(ll);
	}
}
