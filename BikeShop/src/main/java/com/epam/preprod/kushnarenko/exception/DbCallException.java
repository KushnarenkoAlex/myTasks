package main.java.com.epam.preprod.kushnarenko.exception;

public class DbCallException extends RuntimeException {

    private static final long serialVersionUID = 1030304112501589658L;

    public DbCallException() {
    }

    public DbCallException(String message) {
        super(message);
    }

    public DbCallException(Throwable cause) {
        super(cause);
    }

    public DbCallException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
