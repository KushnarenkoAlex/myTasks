package main.java.com.epam.preprod.kushnarenko.utils;

import java.util.UUID;

public final class Util {

	private Util() {
	}

	public static String getKey() {
		return UUID.randomUUID().toString();
		
	}
}
