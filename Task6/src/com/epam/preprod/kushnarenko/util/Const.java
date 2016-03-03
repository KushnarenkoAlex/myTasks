package com.epam.preprod.kushnarenko.util;

import java.util.regex.Pattern;

public class Const {
	public static final String TYPE_COMMAND = "Type command:";
	public static final String BUCKET_TITLE = "~~~~~~~~~~~~~~BUCKET~~~~~~~~~~~~~~";
	public static final String BUCKET_EMPTY = "Bucket is empty";
	public static final String LINE = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
	public static final String BUCKET_CLEAR = "Bucket clear";
	public static final String MENU = "~~~~~~~~~~~~~MENU~~~~~~~~~~~~~\n 0-info\n 1-print list\n 2-print bucket\n 3-show fivelast items\n 4-add itemto bucket\n 5-clear bucket\n 6-buy\n 7-exit\n 8-list of orders between two dates\n 9-add product to db\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
	public static final String HISTORY_TITLE = "~~~~~~~~~~~~~~~HISTORY~~~~~~~~~~~~~~";
	public static final String HISTORY_IS_EMPTY = "History is empty";
	public static final String TYPE_ID = "Type id:";
	public static final String ID_NUMERIC = "Id must be numeric";
	public static final String TYPE_Q = "Type quantity:";
	public static final String Q_NUMERIC = "Quantity must be numeric";
	public static final String TYPE_DATE = "Type date(dd MM yyyy HH mm):";
	public static final String INCORRECT_DATE = "Incorrect date";
	public static final String ORDERS_TITLE = "~~~~~~~~~~~~ORDERS~~~~~~~~~~~~~";
	public static final String WRONG_COMMAND = "Wtong command";
	public static final String DB_FILE = "db.out";
	public static final String TEST_FILE = "testFile.txt";
	public static final String GZIP_FILE = "gZIPFile.txt";
	public static final String LIST_TITLE = "~~~~~~~~~~~~~~LIST~~~~~~~~~~~~~~";
	public static final String BOUGHT_ON = "You bought items on:";
	public static final String MANUAL_INPUT = "Do you want to input object manually: ";
	public static final String MANUAL_ON = "Manual input on";
	public static final String RANDOM_ON = "Random input on";
	public static final String INPUT_CLASS = "Input class name: ";
	public static final String INPUT = "Input data ";
	public static final String CLASS_NOT_FOUND = "Class not found";
	public static final int PORT3000 = 3000;
	public static final String HOST = "localhost";
	public static final int PORT80 = 8080;
	public static final String TCP = "tcp";
	public static final String HTTP = "http";
	public static final String COUNT_TCP = "Count: %s";
	public static final String COUNT_JSON = "{count:%s}";
	public static final String ITEM_INFO_TCP = "%s|%s";
	public static final String ITEM_INFO_JSON = "{name: %s, price: %s}";
	public static final String NO_COMMAND = "Command not found";
	public static final String EXIT = "exit";
	public static final String URL_PATTERN = "^GET /shop/(.*) HTTP/(.*)$";
	public static final String HTTP_PATTERN = "(.*)\\?(.*)=(.*)";
}
