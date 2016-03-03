package main.java.com.epam.preprod.kushnarenko.exception;

/**
 * Call of this means that parsing of security configuration file was
 * unsuccessful.
 * 
 * @author Oleksandr_Kushnarenk
 *
 */
public class ParsingSecurityXMLException extends RuntimeException {

    private static final long serialVersionUID = 1030304112501589658L;

    public ParsingSecurityXMLException() {
    }

    public ParsingSecurityXMLException(String message) {
        super(message);
    }

    public ParsingSecurityXMLException(Throwable cause) {
        super(cause);
    }

    public ParsingSecurityXMLException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
