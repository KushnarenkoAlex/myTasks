package com.epam.preprod.kushnarenko.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.epam.preprod.kushnarenko.entity.Bicycle;
import com.epam.preprod.kushnarenko.util.Const;


/**
 * Class was created only for working with console. 
 * Everything connected with console work is here.
 * 
 * @author Oleksandr_Kushnarenko
 *
 */
public class ConsoleWorker {

	private Scanner sc;

	public ConsoleWorker() {
		this.sc = new Scanner(System.in);
	}

	public String getCommand() {
		System.out.print(Const.TYPE_COMMAND);
		String c = new String();
		c = sc.nextLine();
		return c;
	}

	private void printBucketMap(Map<Bicycle, Integer> map) {
		for (Entry<Bicycle, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " QUANTITY: " + entry.getValue());
		}
	}

	public void printBucket(Shop shop) {
		System.out.println(Const.BUCKET_TITLE);
		Map<Bicycle, Integer> map = shop.getBucketMap();
		if (map.isEmpty()) {
			System.out.println(Const.BUCKET_EMPTY);
		} else {
			printBucketMap(map);
		}
		System.out.println(Const.LINE);
	}

	public void bucketClear() {
		System.out.println(Const.BUCKET_CLEAR);
	}

	public void printInfo() {
		System.out.println(Const.MENU);
	}

	public void printList(Shop shop) {
		System.out.println(Const.LIST_TITLE);
		printBikeCollection(shop.getItemsList());
	}

	private void printBikeCollection(Collection<Bicycle> bicycles) {
		for (Bicycle b : bicycles) {
			System.out.println(b);
		}
	}

	public void printHistory(Shop shop) {
		System.out.println(Const.HISTORY_TITLE);
		Collection<Bicycle> history = shop.getLastFiveCollection();
		if (history.isEmpty()) {
			System.out.println(Const.HISTORY_IS_EMPTY);
		} else {
			printBikeCollection(history);
		}
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

	public void buyBucket(int summ) {
		System.out.println(Const.BOUGHT_ON + summ);
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
