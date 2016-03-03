package main.java.com.epam.preprod.kushnarenko.constants;

public class Const {

    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String PASSWORD = "password";
    public static final String PASSWORD2 = "password2";
    public static final String EMAIL = "email";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String SPAM = "spam";
    public static final String INCORRECT_PASSWORDS = "incorrectPasswords";
    public static final String INCORRECT_LOGIN_DATA = "incorrectLoginData";
    public static final String USER_EXISTS = "userExists";
    public static final String CAPTCHA = "captcha";

    public static final String CURRENT_USER = "currentUser";
    public static final String INSERT_USER = "SQL_INSERT_USER";
    public static final String FIND_USER_BY_EMAIL = "SQL_FIND_USER_BY_EMAIL";
    public static final String SQL_USER_EXISTS = "SQL_USER_EXISTS";
    public static final String FIND_ALL_PRODUCTS = "SQL_GET_ALL_PRODUCTS";
    public static final String FIND_ALL_BRANDS = "SQL_GET_ALL_BRANDS";
    public static final String FIND_ALL_CATEGORIES = "SQL_GET_ALL_CATEGORIES";
    public static final String GET_MAX_PRICE = "SQL_GET_MAX_PRICE";
    public static final String GET_MIN_PRICE = "SQL_GET_MIN_PRICE";
    public static final String GET_PRODUCT_COUNT = "SQL_GET_PRODUCT_COUNT";
    public static final String IMAGE = "image";
    public static final String EMPTY_FIELD = "emptyField";

    public static final String INCORRECT_FIRST_NAME = "incorrectFirstName";
    public static final String INCORRECT_LAST_NAME = "incorrectLastName";
    public static final String INCORRECT_PASSWORD = "incorrectPassword";
    public static final String INCORRECT_EMAIL = "incorrectEmail";
    public static final String INCORRECT_PHONE_NUMBER = "incorrectPhoneNumber";
    public static final String INCORRECT_IMAGE = "incorrectImage";

    public static final String FIRST_NAME_REGEX = "^[A-Za-zР-пр-џ]{1,}$";
    public static final String LAST_NAME_REGEX = "^[A-Za-zР-пр-џ]{1,}$";
    public static final String PASSWORD_REGEX = "^\\w{4,}$";
    public static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String PHONE_NUMBER_REGEX = "^\\d{3}\\s\\d{3}\\s\\d{2}\\s\\d{2}$";
    public static final String SPAM_REGEX = "^(spam)?$";
    public static final String SELECT = "select";
    public static final String SPACE = " ";
    public static final String COMA = ",";
    public static final String FROM = "from";
    public static final String WHERE = "where";
    public static final String ORDER_BY = "order by";
    public static final String DESC = "desc";
    public static final String LIMIT = "limit";
    public static final String PRODUCT_SERVICE = "productService";
    public static final String USER_SERVICE = "userService";
    public static final String BRAND_SERVICE = "brandService";
    public static final String CATEGORY_SERVICE = "categoryService";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/bike_shop_db";
    public static final String USER_NAME = "root";
    public static final String USER_PASSWORD = "root";
    public static final String PRODUCTS = "products";
    public static final String BRANDS = "brands";
    public static final String CATEGORIES = "categories";
    public static final String OR = "or";
    public static final String EMPTY_STRING = "";
}
