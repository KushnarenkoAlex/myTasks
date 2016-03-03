package com.epam.preprod.kushnarenko.logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;

import com.epam.preprod.kushnarenko.entity.Product;
import com.epam.preprod.kushnarenko.util.Const;

/**
 * Class that combines bucket, cash, orders and DB,
 * 
 * @author Oleksandr_Kushnarenko
 *
 */

public class Shop {

	private Bucket bucket;

	private Cash cash;

	private ProductDB db;

	private Orders orders;

	public Shop() {
		bucket = new Bucket();
		cash = new Cash();
		orders = new Orders();
		try {
			db = this.open();
		} catch (Exception e) {
			db = new ProductDB();
		}
	}

	public ProductDB getDB() {
		return db;

	}

	public Collection<Product> getItemsList() {
		return db.getCollection();
	}

	/**
	 * Gets map with ItemID and Quantity find Item by id in DB and returns map
	 * with Item and Quantity. Comfortable for printing bucket.
	 * 
	 * @author Oleksandr_Kushnarenko
	 *
	 */
	public Map<Product, Integer> getBucketMap() {
		Map<Integer, Integer> c = bucket.getCollection();
		LinkedHashMap<Product, Integer> res = new LinkedHashMap<>();
		for (Entry<Integer, Integer> entry : c.entrySet()) {
			res.put(db.getById(entry.getKey()), entry.getValue());
		}
		return Collections.unmodifiableMap(res);
	}

	public Collection<Product> getLastFiveCollection() {
		return cash.getCollection();
	}

	public void clearBucket() {
		this.bucket.clear();
	}

	public void addItem(int id, int quantity) {
		Product b = db.getById(id);
		bucket.put(id, quantity);
		cash.add(b);
	}

	public int getDBSize() {
		return db.size();
	}

	/**
	 * Returns summary price of all items in bucket including quantity of these
	 * items. And adds all these items to orders list like a new order.
	 * 
	 * @author Oleksandr_Kushnarenko
	 *
	 */
	public int buyBucket(Date date) {
		int summ = 0;
		Order order = new Order();
		Map<Integer, Integer> c = bucket.getCollection();
		for (Entry<Integer, Integer> entry : c.entrySet()) {
			int id = entry.getKey();
			Product bi = db.getById(id);
			Integer quantity = bucket.getValue(id);
			order.add(bi, quantity);
			summ += Math.multiplyExact(bi.getPrice().intValue(), quantity);
		}
		orders.add(date, order);
		return summ;
	}

	public String getStringSubList(Date dateFrom, Date dateTo) {
		SortedMap<Date, Order> list = orders.subOrders(dateFrom, dateTo);
		StringBuilder sb = new StringBuilder();
		for (Entry<Date, Order> en : list.entrySet()) {
			sb.append(en.getValue()).append(System.lineSeparator());
		}
		return sb.toString();
	}

	public String getClosest(Date date) {
		return orders.nearest(date).toString();
	}

	public void save() {
		try {
			ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(Const.DB_FILE));
			ois.writeObject(db);
			ois.flush();
			ois.close();
		} catch (Exception e) {
		}

	}

	private ProductDB open() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Const.DB_FILE));
		ProductDB db = (ProductDB) ois.readObject();
		ois.close();
		return db;
	}

	public void addToDB(Product product) {
		db.add(product);
	}
}
