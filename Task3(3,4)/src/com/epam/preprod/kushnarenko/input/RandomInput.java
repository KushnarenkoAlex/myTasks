package com.epam.preprod.kushnarenko.input;

import java.util.Scanner;

import com.epam.preprod.kushnarenko.entity.Product;

public class RandomInput implements TypeInput {

	@Override
	public void execute(Product p,Scanner s) {
		System.out.println("RANDOM");
		p.random();
	}

}
