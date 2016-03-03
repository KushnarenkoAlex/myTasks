package com.epam.preprod.kushnarenko.chain;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatFilter extends Filter {

	private String formatRegex;

	public FormatFilter(Filter next, String s) {
		super(next);
		formatRegex = "(.)*\\." + s;
	}

	@Override
	protected boolean match(File file) {
		Matcher m = Pattern.compile(formatRegex).matcher(file.getName());
		return m.matches();
	}

}
