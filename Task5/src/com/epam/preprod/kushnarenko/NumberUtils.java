package com.epam.preprod.kushnarenko;

public class NumberUtils {

	public static boolean isSimple(int num) {
		for (int j = 2; j <= num / 2; j++) {
			if (num % j == 0) {
				return false;
			}
		}
		return true;
	}

}
