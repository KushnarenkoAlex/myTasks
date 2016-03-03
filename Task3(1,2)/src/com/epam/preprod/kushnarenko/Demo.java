package com.epam.preprod.kushnarenko;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import com.epam.preprod.kushnarenko.chain.DateFilter;
import com.epam.preprod.kushnarenko.chain.Filter;
import com.epam.preprod.kushnarenko.chain.FormatFilter;
import com.epam.preprod.kushnarenko.chain.NameFilter;
import com.epam.preprod.kushnarenko.chain.SizeFilter;

public class Demo {

	public static void main(String[] args) {

		System.out.print(Const.INPUT_DIR);

		String s = Util.nextLine();
		Collection<File> al = Util.findFiles(new File(s));
		Filter ff = null;

		if (Util.input(Const.FIND_BY_NAME)) {
			s = Util.getString(Const.INPUT_WORD);
			ff = new NameFilter(ff, s);
		}
		if (Util.input(Const.FIND_BY_FORMAT)) {
			s = Util.getString(Const.INPUT_FORMAT);
			ff = new FormatFilter(ff, s);
		}

		if (Util.input(Const.FIND_BY_SIZE)) {
			s = Util.getString(Const.INPUT_SIZE);
			String[] ss = s.split(" ");
			try {
				Long from = Long.parseLong(ss[0]);
				Long to = Long.parseLong(ss[1]);
				ff = new SizeFilter(ff, from, to);
			} catch (Exception e) {
				System.err.println(Const.WRONG_SIZE);
			}
		}

		if (Util.input(Const.FIND_BY_DATE)) {
			String dateFrom = Util.getString(Const.INPUT_DATE_FROM);
			String dateTo = Util.getString(Const.INPUT_DATE_TO);
			SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy HH mm");
			Date from = new Date();
			Date to = new Date();
			try {
				from = sdf.parse(dateFrom);
				to = sdf.parse(dateTo);
				ff = new DateFilter(ff, from, to);
			} catch (Exception e) {
				System.err.println(Const.WRONG_DATE);
			}
		}

		for (File f : al) {
			if (ff != null) {
				if (ff.filterData(f)) {
					System.out.println(f);
				}
			} else {
				System.out.println(f);
			}
		}
	}
}
