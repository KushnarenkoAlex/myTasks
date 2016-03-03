package com.epam.preprod.kushnarenko.logic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import com.epam.preprod.kushnarenko.entity.MountainBike;
import com.epam.preprod.kushnarenko.entity.Product;

public class ProductDB implements Serializable {

	private static final long serialVersionUID = 989429594386586463L;

	private LinkedHashMap<Integer, Product> productsList;

	public ProductDB() {
		productsList = new LinkedHashMap<>();
		init();
	}

	public Product getById(int id) {
		return productsList.get(id);
	}

	/**
	 * Keys are only for a fast search, so i dont need keys outside of this
	 * class. That is why it returns just collection of values.
	 * 
	 * @author Oleksandr_Kushnarenko
	 *
	 */
	public Collection<Product> getCollection() {
		LinkedList<Product> ll = new LinkedList<>();
		for (Entry<Integer, Product> entry : productsList.entrySet()) {
			ll.add(entry.getValue());
		}
		return Collections.unmodifiableCollection(ll);
	}

	public BigDecimal getPrice(int id) {
		return getById(id).getPrice();
	}

	/**
	 * Initialize 10 new items in "DB"
	 * 
	 * @author Oleksandr_Kushnarenko
	 *
	 */
	private void init() {
		for (int i = 0; i < 10; i++) {
			productsList.put(i, new MountainBike(i, i * 15, 50 + i * 2, "material" + i, 500 + i * 10, 1999 + i,
					"Model_" + i, i + 1, "handBrakes", 10, true));
		}
	}

	public int size() {
		return productsList.size();
	}

	public void add(Product p) {
		productsList.put(p.getId(), p);
	}

}
