package com.epam.preprod.kushnarenko.logic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import com.epam.preprod.kushnarenko.entity.Bicycle;
import com.epam.preprod.kushnarenko.entity.MountainBike;

public class BicycleDB implements Serializable {

	private static final long serialVersionUID = 989429594386586463L;

	private LinkedHashMap<Integer, Bicycle> bicycleList;

	public BicycleDB() {
		bicycleList = new LinkedHashMap<>();
		init();
	}

	/**
	 * Initialize 10 new items in "DB"
	 * 
	 * @author Oleksandr_Kushnarenko
	 *
	 */
	private void init() {
		for (int i = 0; i < 10; i++) {
			bicycleList.put(i, new MountainBike(i, i * 15, 50 + i * 2, "material" + i, 500 + i * 10, 1999 + i,
					"Model_" + i, i + 1, "handBrakes", 10, true));
		}
	}

	public Bicycle getById(int id) {
		return bicycleList.get(id);
	}

	public BigDecimal getPrice(int id) {
		return getById(id).getPrice();
	}

	/**
	 * Keys are only for a fast search, so i dont need keys outside of this class.
	 * That is why it returns just collection of values.
	 * 
	 * @author Oleksandr_Kushnarenko
	 *
	 */
	public Collection<Bicycle> getCollection() {
		LinkedList<Bicycle> ll = new LinkedList<>();
		for (Entry<Integer, Bicycle> entry : bicycleList.entrySet()) {
			ll.add(entry.getValue());
		}
		return Collections.unmodifiableCollection(ll);
	}

	public int size() {
		return bicycleList.size();
	}

}
