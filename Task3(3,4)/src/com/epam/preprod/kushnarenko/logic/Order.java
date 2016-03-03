package com.epam.preprod.kushnarenko.logic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.epam.preprod.kushnarenko.entity.Product;

/**
 * Class order stores ordered Items and Quantities
 * 
 * @author Oleksandr_Kushnarenko
 *
 */
public class Order {

	private HashMap<Product, Integer> items;

	public Order() {
		items = new HashMap<>();
	}

	public Map<Product, Integer> getOrders() {
		return Collections.unmodifiableMap(items);
	}

	public void add(Product b, Integer quantity) {
		items.put(b, quantity);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}

}
