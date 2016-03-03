package com.epam.preprod.kushnarenko.logic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.epam.preprod.kushnarenko.entity.Bicycle;

/**
 * Class order stores ordered Items and Quantities 
 * 
 * @author Oleksandr_Kushnarenko
 *
 */
public class Order {

	private HashMap<Bicycle, Integer> items;

	public Order() {
		items = new HashMap<>();
	}

	public Map<Bicycle, Integer> getOrders() {
		return Collections.unmodifiableMap(items);
	}

	public void add(Bicycle b, Integer quantity) {
		items.put(b, quantity);
	}

}
