package com.epam.preprod.kushnarenko.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.epam.preprod.kushnarenko.entity.Product;
import com.epam.preprod.kushnarenko.input.HandInput;
import com.epam.preprod.kushnarenko.input.RandomInput;
import com.epam.preprod.kushnarenko.input.TypeInput;
import com.epam.preprod.kushnarenko.logic.Shop;

/**
 * Class was created only for working with console. Everything connected with
 * console work is here.
 * 
 * @author Oleksandr_Kushnarenko
 *
 */
public class ConsoleWorker {

	private Scanner sc;
	ProductsList pl;
	private TypeInput input;

	public ConsoleWorker() {
		this.sc = new Scanner(System.in);
		chooseInputType();
		pl = new ProductsList();
	}

	public void bucketClear() {
		System.out.println(Const.BUCKET_CLEAR);
	}

	public void buyBucket(int summ) {
		System.out.println(Const.BOUGHT_ON + summ);
	}

	private void chooseInputType() {
		System.out.print(Const.MANUAL_INPUT);
		String s = sc.nextLine();
		if (s.equals("1")) {
			input = new HandInput();
			System.out.println(Const.MANUAL_ON);
		} else {
			input = new RandomInput();
			System.out.println(Const.RANDOM_ON);
		}

	}

	public String getCommand() {
		System.out.print(Const.TYPE_COMMAND);
		String c = new String();
		c = sc.nextLine();
		return c;
	}

	public Date getDate() {
		Date date;
		while (true) {
			System.out.print(Const.TYPE_DATE);
			String s = sc.nextLine();
			System.out.println(s);
			SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy HH mm");
			try {
				date = sdf.parse(s);
				break;
			} catch (ParseException e) {
				System.out.println(Const.INCORRECT_DATE);
			}
		}
		return date;
	}

	public int getId() {
		Integer id = -1;
		while (true) {
			System.out.print(Const.TYPE_ID);
			try {
				id = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(Const.ID_NUMERIC);
			}
		}
		return id;
	}

	public Product getProduct(String className) {
		Product p = null;
		while (true) {
			p = pl.get(className);
			if (!p.equals(null)) {
				input.execute(p, sc);
				break;
			} else {
				System.out.println(Const.CLASS_NOT_FOUND);
			}
		}
		return p;
	}

	public String getProductName() {
		System.out.println(Const.INPUT_CLASS);
		for (Entry<String, Product> e : pl.getMap().entrySet()) {
			System.out.print(e.getKey() + ", ");
		}
		String s = sc.nextLine();
		return s;
	}

	public int getQuantity() {
		Integer quantity = -1;
		while (true) {
			System.out.print(Const.TYPE_Q);
			try {
				quantity = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(Const.Q_NUMERIC);
			}
		}
		return quantity;
	}

	public void printBucket(Shop shop) {
		System.out.println(Const.BUCKET_TITLE);
		Map<Product, Integer> map = shop.getBucketMap();
		if (map.isEmpty()) {
			System.out.println(Const.BUCKET_EMPTY);
		} else {
			printBucketMap(map);
		}
		System.out.println(Const.LINE);
	}

	private void printBucketMap(Map<Product, Integer> map) {
		for (Entry<Product, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " QUANTITY: " + entry.getValue());
		}
	}

	public void printHistory(Shop shop) {
		System.out.println(Const.HISTORY_TITLE);
		Collection<Product> history = shop.getLastFiveCollection();
		if (history.isEmpty()) {
			System.out.println(Const.HISTORY_IS_EMPTY);
		} else {
			printProductCollection(history);
		}
	}

	public void printInfo() {
		System.out.println(Const.MENU);
	}

	public void printList(Shop shop) {
		System.out.println(Const.LIST_TITLE);
		printProductCollection(shop.getItemsList());
	}

	private void printProductCollection(Collection<Product> products) {
		for (Product b : products) {
			System.out.println(b);
		}
	}

	public void printSubList(Shop shop) {
		Date dateFrom = this.getDate();
		Date dateTo = this.getDate();
		System.out.println(Const.ORDERS_TITLE);
		System.out.println(shop.getStringSubList(dateFrom, dateTo));
	}

	public void wrongCommand() {
		System.out.println(Const.WRONG_COMMAND);

	}

}
