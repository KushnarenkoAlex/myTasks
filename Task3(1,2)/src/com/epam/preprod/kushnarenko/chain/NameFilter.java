package com.epam.preprod.kushnarenko.chain;

import java.io.File;

public class NameFilter extends Filter {

	private String word;

	public NameFilter(Filter next, String s) {
		super(next);
		word = s;
	}

	@Override
	protected boolean match(File file) {
		return file.getName().contains(word);
	}

}
