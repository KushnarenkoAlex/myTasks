package com.epam.preprod.kushnarenko.chain;

import java.io.File;

public abstract class Filter {

	protected Filter next;

	public Filter(Filter next) {
		this.next = next;
	}

	public boolean filterData(File file) {
		boolean b = match(file);
		if (!b) {
			return false;
		}
		if (next != null) {
			return next.filterData(file);
		}
		return true;
	}

	abstract protected boolean match(File file);
}
