package com.epam.preprod.kushnarenko;

import java.util.Scanner;

public class ScannerInstance {
	
	private static Scanner scanner;

	private ScannerInstance() {
	}

	public static synchronized Scanner getScanner() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}
		return scanner;

	}

	public static synchronized void close() {
		if (scanner != null) {
			scanner.close();
		}
	}

}
