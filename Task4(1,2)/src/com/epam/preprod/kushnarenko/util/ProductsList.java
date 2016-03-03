package com.epam.preprod.kushnarenko.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.epam.preprod.kushnarenko.entity.MountainBike;
import com.epam.preprod.kushnarenko.entity.Product;

public class ProductsList {

	HashMap<String, Product> products;

	public ProductsList() {
		products = new HashMap<>();
		products.put("MountainBike", new MountainBike());
	}

	public Product get(String name) {
		return products.get(name);
	}

	public Map<String, Product> getMap() {
		return Collections.unmodifiableMap(products);
	}

}
