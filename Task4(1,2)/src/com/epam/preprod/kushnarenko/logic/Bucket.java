package com.epam.preprod.kushnarenko.logic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Bucket {

	private HashMap<Integer, Integer> container;

	public Bucket() {
		container = new HashMap<>();
	}

	public void put(Integer goodId, Integer quantity) {
		if (quantity <= 0) {
			throw new IndexOutOfBoundsException();
		}
		if (container.containsKey(goodId)) {
			container.put(goodId, container.get(goodId) + quantity);
		}
		container.put(goodId, quantity);
	}

	public Integer getValue(Integer key) {
		return container.get(key);
	}

	public void clear() {
		this.container.clear();
	}

	public Map<Integer, Integer> getCollection() {
		return Collections.unmodifiableMap(container);
	}

}
