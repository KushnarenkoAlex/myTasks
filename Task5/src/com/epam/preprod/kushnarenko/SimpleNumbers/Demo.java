package com.epam.preprod.kushnarenko.SimpleNumbers;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int from = 0, to = 0, num = 0;
		while (true) {
			System.out.println(Const.INPUT);
			String s = sc.nextLine();
			try {
				String[] ss = s.split(" ");
				from = Integer.parseInt(ss[0]);
				to = Integer.parseInt(ss[1]);
				num = Integer.parseInt(ss[2]);
				break;
			} catch (Exception e) {
				System.out.println(Const.WRONG);
			}
		}
		int k = (to - from) / num;
		ArrayList<Integer> al = new ArrayList<>();
		ArrayList<SimpleThread> threadsList = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			threadsList.add(new SimpleThread(i * k + from, k, al));
		}
		long startTime = System.currentTimeMillis();
		for (Thread t : threadsList) {
			t.start();
		}
		for (Thread t : threadsList) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("TIME-" + (System.currentTimeMillis() - startTime));
	}
}
