package com.epam.preprod.kushnarenko.logic;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import com.epam.preprod.kushnarenko.entity.Bicycle;

public class Cash {

	private LinkedHashMap<Integer, Bicycle> goodsCash;

	private static Integer MAX_NUMBER = 5;

	/**
	 * Method removeEldestEntry allows to store only 5 last bought items.
	 * 
	 * @author Oleksandr_Kushnarenko
	 *
	 */
	public Cash() {
		goodsCash = new LinkedHashMap<Integer, Bicycle>() {

			private static final long serialVersionUID = 7566466907258679826L;

			protected boolean removeEldestEntry(Map.Entry<Integer, Bicycle> eldest) {
				return size() > MAX_NUMBER;
			}
		};
	}

	public void add(Bicycle b) {
		goodsCash.put(b.getId(), b);
	}

	public Collection<Bicycle> getCollection() {
		LinkedList<Bicycle> ll = new LinkedList<>();
		for (Entry<Integer, Bicycle> entry : goodsCash.entrySet()) {
			ll.add(entry.getValue());
		}
		return Collections.unmodifiableCollection(ll);
	}
}
