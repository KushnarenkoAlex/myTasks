package com.epam.preprod.kushnarenko.Sequence;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.epam.preprod.kushnarenko.SimpleNumbers.Const;

public class Demo {

	public static ArrayList<Byte> al;

	public static boolean done;

	public static void main(String[] args) throws IOException, InterruptedException {
		Object monitor = new Object();
		SequenceThread st = new SequenceThread(monitor);
		st.start();
		done = false;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		synchronized (monitor) {
			while (true) {
				System.out.println("Type file name or exit");
				String s = sc.nextLine();
				if (s.equals(Const.EXIT)) {
					break;
				}
				done = false;
				InputStream is = new FileInputStream(s);
				al = new ArrayList<>();
				for (int b = is.read(); b >= 0; b = is.read()) {
					al.add((byte) b);
				}
				System.out.println(al);
				while (!done) {
					monitor.notifyAll();
					monitor.wait();
					System.out.println("Biggest sequence size = " + st.getSeq().size());
				}
				System.out.println(st.getSeq() + " FIRST " + st.getFirst() + " SECOND " + st.getSecond());
				is.close();
			}
		}
	}
}
