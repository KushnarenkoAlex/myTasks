package com.epam.preprod.kushnarenko.Sequence;

import java.util.ArrayList;
import java.util.List;

public class SequenceThread extends Thread {

	private Object monitor;

	private ArrayList<Byte> seq = new ArrayList<>();

	private int first, second;

	public SequenceThread(Object o) {
		setDaemon(true);
		monitor = o;
	}

	public int getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
	}

	public Integer getLen() {
		return seq.size();
	}

	@SuppressWarnings("unused")
	@Override
	public void run() {
		synchronized (monitor) {
			while (true) {
				if (!Demo.done) {
					try {
						monitor.wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					System.out.println("BEGIN");
					seq.clear();
					first = 0;
					second = 0;
					ArrayList<Byte> al = Demo.al;
					int len = 2;
					while (len < al.size()) {
						boolean flag = false;
						for (int pos = 0; pos <= al.size() - len; pos++) {
							List<Byte> temp = al.subList(pos, pos + len);
							for (int i = pos + 1; i <= al.size() - len; i++) {
								List<Byte> temp2 = al.subList(i, i + len);
								if (temp2.equals(temp)) {
									flag = true;
									len++;
									seq = new ArrayList<>(temp2);
									first = pos;
									second = i;
									monitor.notifyAll();
									try {
										monitor.wait();
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									break;
								}
							}
							break;
						}
						if (!flag) {
							break;
						}
					}
					Demo.done = true;
					monitor.notifyAll();
				} else {
					break;
				}
			}
		}
	}

	public ArrayList<Byte> getSeq() {
		return seq;
	}
}
