package ua.nure.serdyuk.SummaryTask4.constants;

public final class Const {
	// attributes
	public static final String ERRORS = "errors";

	public static final String EMAIL = "email";

	public static final String PASSWORD = "password";

	public static final String PASSWORD_REPEAT = "repPassword";

	public static final String FIRST_NAME = "firstName";

	public static final String LAST_NAME = "lastName";

	public static final String ROLE = "role";

	public static final String ROUTE_ID = "routeId";
	
	public static final String TRAIN_ID = "trainId";

	public static final String STATION_FROM = "stationFrom";

	public static final String STATION_TO = "stationTo";

	public static final String DATE = "date";
	
	public static final String DATE_FROM = "dateFrom";
	
	public static final String DATE_TO = "dateTo";
	
	public static final String REDIRECT = "redirect";

	public static final String CURRENT_USER = "currentUser";

	public static final String CARRIAGE_LIST = "carriageList";

	public static final String TICKET_ORDER_BEAN = "ticketOrderBean";
	
	public static final String ROUTE_ADD_MES = "routeAddMes";

	public static final String ROUTE_ADD_ERR = "routeAddError";

	public static final String USER_SERVICE = "userService";

	public static final String STATION_SERVICE = "stationService";

	public static final String TRAIN_SERVICE = "trainService";

	public static final String ROUTE_SERVICE = "routeService";

	public static final String ROUTE_ITEM_SERVICE = "routeItemService";

	public static final String TRAIN_BEAN_SERVICE = "trainBeanService";

	public static final String ROUTE_INFO_SERVICE = "routeInfoService";

	public static final String CARRIAGE_SERVICE = "carriageService";
	
	public static final String CARRIAGE_TYPE_SERVICE = "carTypeService";

	public static final String TICKET_SERVICE = "ticketService";

	public static final String CURRENT_LOCALE = "currentLocale";

	public static final String CURRENT_LOCALE_LOCALE = "currentLocaleLocale";

	public static final String NEW_LOCALE = "lang";

	public static final String DEFAULT_LOCALE = "defaultLocale";

	public static final String BUNDLE_BASENAME = "bundleBasename";

	public static final String LOCALE_LIST = "localeList";

	public static final String LOCALE_LIST_LOCALE = "localeListLocale";

	public static final String TRAIN_INFO_BEANS = "trainBeans";

	public static final String ROUTE_INFO_BEANS = "routeInfoBeans";

	// sql keys
	public static final String GET_USER_BY_ID = "SQL_SELECT_USER_BY_ID";

	public static final String GET_USER_BY_EMAIL = "SQL_SELECT_USER_BY_EMAIL";

	public static final String INSERT_USER = "SQL_INSERT_USER";

	public static final String GET_STATION_BY_NAME = "SQL_GET_STATION_BY_NAME";

	public static final String GET_ALL_STATIONS = "SQL_GET_ALL_STATIONS";

	public static final String GET_ALL_STATIONS_LIKE = "SQL_GET_ALL_STATIONS_LIKE";

	public static final String GET_STATIONS_BY_ROUTE_ITEMS = "SQL_SELECT_STATIONS_BY_ROUTE_ITEMS";

	public static final String GET_ROUTE_INFO_BY_TRAIN_ID = "SQL_GET_ROUTE_INFO_BY_TRAIN_ID";

	public static final String GET_ALL_ROUTE_ITEMS_BY_TRAIN_ID_FROM_TO = "SQL_GET_ALL_ROUTE_ITEMS_BY_TRAIN_ID_FROM_TO";

	public static final String GET_ROUTE_BY_STATIONS_AND_DATE = "SQL_SELECT_ROUTE_BY_STATIONS_AND_DATE";

	public static final String GET_TRAIN_INFO_BY_TRAIN_ID_ROUTE_STATIONS = "SQL_GET_TRAIN_INFO_BY_TRAIN_ID_ROUTE_STATIONS";

	public static final String GET_CARRIAGE_INFO_BY_TRAIN_ID_ROUTE_ITEMS = "SQL_GET_CARRIAGE_INFO_BY_TRAIN_ID_ROUTE_ITEMS";
	
	public static final String GET_CARRIAGE_INFO_BY_TRAIN_ID = "SQL_GET_CARRIAGE_INFO_BY_TRAIN_ID";

	public static final String GET_TAKEN_SEATS_BY_CAR_ID_AND_ROUTE_ID = "SQL_GET_TAKEN_SEATS_BY_CAR_ID_AND_ROUTE_ID";

	public static final String GET_PRICE_BY_TRAIN_ID_CAR_TYPE_AND_ORDINALS = "SQL_GET_PRICE_BY_TRAIN_ID_CAR_TYPE_AND_ORDINALS";

	public static final String GET_CARRIAGE_TYPES = "SQL_GET_CARRIAGE_TYPES";

	public static final String SQL_CREATE_STATION = "SQL_INSERT_STATION";

	public static final String SQL_DELETE_STATION = "SQL_DELETE_STATION";

	public static final String SQL_UPDATE_STATION = "SQL_UPDATE_STATION";

	public static final String SQL_GET_ALL_TRAINS = "SQL_GET_ALL_TRAINS";

	public static final String SQL_CREATE_TRAIN = "SQL_INSERT_TRAIN";

	public static final String SQL_CREATE_ROUTE_ITEM = "SQL_INSERT_ROUTE_ITEM";

	public static final String SQL_INSERT_ROUTE = "SQL_INSERT_ROUTE";

	public static final String SQL_INSERT_TICKET = "SQL_INSERT_TICKET";
	
	public static final String SQL_CREATE_CARRIAGE = "SQL_INSERT_CARRIAGE";
	
	public static final String SQL_DELETE_ROUTE = "SQL_DELETE_ROUTE";
	
	public static final String SQL_GET_ALL_ROUTES_BY_DATES = "SQL_GET_ALL_ROUTES_BY_DATES";
	
	public static final String SQL_GET_TRAIN_BY_ID = "SQL_GET_TRAIN_BY_ID";
	
	public static final String SQL_GET_ALL_CAR_TYPES = "SQL_GET_ALL_CAR_TYPES";
	

	// regex
	public static final String REGEX_EMAIL = "^\\w+@\\w+\\.\\w+$";

	public static final String REGEX_PASSWORD = "^\\w{4,}$";

	public static final String REGEX_NAME = "^\\p{javaUpperCase}[\\wА-Яа-я-]{1,30}$";

	// stuff
	public static final String CLIENT_DATE_FORMAT = "MM/dd/yyyy";

	public static final String CLIENT_TIME_FORMAT = "h:mm a";
}