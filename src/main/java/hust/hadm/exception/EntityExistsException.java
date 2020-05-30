package hust.hadm.exception;

public class EntityExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityExistsException() {
		// TODO Auto-generated constructor stub
	}

	public EntityExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EntityExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public EntityExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EntityExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
