package com.epam.preprod.kushnarenko.input;

import java.util.Scanner;

import com.epam.preprod.kushnarenko.entity.Product;
import com.epam.preprod.kushnarenko.util.InputWorker;

public class HandInput implements TypeInput {

	@Override
	public void execute(Product p, Scanner s) {
		InputWorker iw = InputWorker.getInstance();
		iw.createObject(p);
		//For old tasks.
		// System.out.println(Const.INPUT + p.getExample() + " :");
		// String str = s.nextLine();
		// p.parse(str);
	}

}
