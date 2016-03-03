package com.epam.preprod.kushnarenko.SimpleNumbers;

import java.util.ArrayList;

import com.epam.preprod.kushnarenko.NumberUtils;

public class SimpleThread extends Thread {

	private int from, count;
	private ArrayList<Integer> al;

	public SimpleThread(int from, int count, ArrayList<Integer> al) {
		System.out.println("FROM " + from + " TO " + (from + count));
		this.from = from;
		this.count = count;
		this.al = al;
	}

	@Override
	public void run() {
		for (int z = from; z < from + count; z++) {
			if (NumberUtils.isSimple(z)) {
				synchronized (al) {
					System.out.println(z + " " + this.getName());
					al.add(z);
				}
			}
		}
	}
}
