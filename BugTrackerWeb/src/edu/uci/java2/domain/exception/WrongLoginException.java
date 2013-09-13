package edu.uci.java2.domain.exception;

public class WrongLoginException extends Exception {

	private static final long serialVersionUID = 4106610438496947723L;

	public WrongLoginException() {
		super();
	}

	public WrongLoginException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public WrongLoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public WrongLoginException(String message) {
		super(message);
	}

	public WrongLoginException(Throwable cause) {
		super(cause);
	}

}
