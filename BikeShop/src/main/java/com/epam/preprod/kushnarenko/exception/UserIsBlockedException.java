package main.java.com.epam.preprod.kushnarenko.exception;

/**
 * Call of this means that parsing of security configuration file was
 * unsuccessful.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class UserIsBlockedException extends RuntimeException {

    private static final long serialVersionUID = 1030304112501589658L;

    public UserIsBlockedException() {
    }

    public UserIsBlockedException(String message) {
        super(message);
    }

    public UserIsBlockedException(Throwable cause) {
        super(cause);
    }

    public UserIsBlockedException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
