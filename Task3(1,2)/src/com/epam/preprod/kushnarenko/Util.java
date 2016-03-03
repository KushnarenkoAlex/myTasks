package com.epam.preprod.kushnarenko;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public final class Util {

	public static Collection<File> findFiles(File directory) {
		List<File> list = new LinkedList<File>();
		for (File file : directory.listFiles()) {
			if (!file.isFile()) {
				list.addAll(findFiles(file));
			} else {
				list.add(file);
			}
		}
		return list;
	}

	/**
	 * Asks question and returns boolean value in depend of user answer
	 * 
	 * @param question
	 * @param sc
	 * @return
	 */
	public static boolean input(String question) {
		while (true) {
			Scanner sc=ScannerInstance.getScanner();
			System.out.print(question);
			String answer = sc.nextLine();
			if (answer.equals(Const.ONE)) {
				return true;
			}
			if (answer.equals(Const.ZERO)) {
				return false;
			}
			System.err.println(Const.TYPE_ONE_OR_ZERO);
		}
	}

	public static String nextLine() {
		return ScannerInstance.getScanner().nextLine();
	}

	public static String getString(String message) {
		System.out.print(message);
		return ScannerInstance.getScanner().nextLine();
	}

}
