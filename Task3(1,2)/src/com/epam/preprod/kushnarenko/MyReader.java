package com.epam.preprod.kushnarenko;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class MyReader implements Iterable<String> {

	private BufferedReader bis;

	public MyReader(String fileName) throws FileNotFoundException {
		bis = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
	}

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			private String tempString;

			@Override
			public boolean hasNext() {
				try {
					tempString = bis.readLine();
					if (tempString != null) {
						return true;
					}
				} catch (IOException e) {
					System.out.println("EXCEPTION");
				}
				return false;
			}

			@Override
			public String next() {
				return tempString;
			}
		};
	}

}
