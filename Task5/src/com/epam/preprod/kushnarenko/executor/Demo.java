package com.epam.preprod.kushnarenko.executor;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.epam.preprod.kushnarenko.SimpleNumbers.Const;
import com.epam.preprod.kushnarenko.SimpleNumbers.SimpleThread;

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
		ExecutorService ex = Executors.newFixedThreadPool(num);
		for (int i = 0; i < num; i++) {
			ex.execute(new SimpleThread(i * k + from, k, al));
		}
		ex.shutdown();
		for (Integer i : al) {
			System.out.println(i);
		}
	}
}
