package ua.nure.serdyuk.SummaryTask4.exception;

/**
 * @{code AppException} and its subclasses represent specific for this
 *        application exceptions.
 * @author Daria Serdiuk
 *
 */
public class AppException extends RuntimeException {

	private static final long serialVersionUID = -7516367241698123485L;
	
	public AppException() {
		super();
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String message) {
		super(message);
	}
}
