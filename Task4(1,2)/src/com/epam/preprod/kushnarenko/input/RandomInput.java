package com.epam.preprod.kushnarenko.input;

import java.util.Scanner;

import com.epam.preprod.kushnarenko.entity.Product;
import com.epam.preprod.kushnarenko.util.InputWorker;

public class RandomInput implements TypeInput {

	@Override
	public void execute(Product p,Scanner s) {
		InputWorker iw = InputWorker.getInstance();
		iw.createRandomObject(p);
	}

}
