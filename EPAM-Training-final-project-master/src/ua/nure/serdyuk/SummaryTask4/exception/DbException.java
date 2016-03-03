package ua.nure.serdyuk.SummaryTask4.exception;

/**
 * This exception is thrown when something went wrong in data access layer.
 * 
 * @author Daria Serdiuk
 *
 */
public class DbException extends AppException {

	private static final long serialVersionUID = -2198669789913933390L;

	public DbException() {
		super();
	}

	public DbException(String message, Throwable cause) {
		super(message, cause);
	}

	public DbException(String message) {
		super(message);
	}

}
