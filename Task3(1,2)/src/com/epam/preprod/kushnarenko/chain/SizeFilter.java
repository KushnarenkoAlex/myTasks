package com.epam.preprod.kushnarenko.chain;

import java.io.File;

public class SizeFilter extends Filter {

	private Long from, to;

	public SizeFilter(Filter next, Long from, Long to) {
		super(next);
		this.from = from;
		this.to = to;
	}

	@Override
	protected boolean match(File file) {
		return file.length() > from && file.length() < to;
	}

}
