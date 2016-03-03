package com.epam.preprod.kushnarenko.logic;

import java.util.Date;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Stores orders history
 * 
 * @author Oleksandr_Kushnarenko
 *
 */

public class Orders {
	public TreeMap<Date, Order> map;

	public Orders() {
		map = new TreeMap<>();
	}

	public void add(Date date, Order order) {
		map.put(date, order);
	}

	public SortedMap<Date, Order> subOrders(Date dateFrom, Date dateTo) {
		return map.subMap(dateFrom, dateTo);
	}

	public Order nearest(Date toFrom) {
		Entry<Date, Order> low = map.floorEntry(toFrom);
		Entry<Date, Order> high = map.ceilingEntry(toFrom);
		if (low != null && high != null) {
			long l = low.getKey().getTime();
			long h = high.getKey().getTime();
			long tf = toFrom.getTime();
			if (Math.abs(l - tf) > Math.abs(h - tf)) {
				return high.getValue();
			}
			return low.getValue();
		}
		return (Order) (low != null ? low : (high != null ? high : null));

	}

}
