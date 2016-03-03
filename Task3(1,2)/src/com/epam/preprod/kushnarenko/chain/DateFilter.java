package com.epam.preprod.kushnarenko.chain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

public class DateFilter extends Filter {

	private Date from, to;

	public DateFilter(Filter next, Date from, Date to) {
		super(next);
		this.from = from;
		this.to = to;
	}

	@Override
	protected boolean match(File file) {
		BasicFileAttributes attr = null;
		try {
			attr = Files.readAttributes(Paths.get(file.toString()), BasicFileAttributes.class);
		} catch (IOException e) {
		}
		Long d = attr.lastModifiedTime().toMillis();
		return d < to.getTime() && d > from.getTime();
	}

}
