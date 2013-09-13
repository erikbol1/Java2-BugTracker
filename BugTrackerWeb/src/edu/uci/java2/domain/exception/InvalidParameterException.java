package edu.uci.java2.domain.exception;

public class InvalidParameterException extends Exception {

	private static final long serialVersionUID = 165461882064924844L;


	public InvalidParameterException() {
		super();
	}

	public InvalidParameterException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidParameterException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidParameterException(String message) {
		super(message);
	}

	public InvalidParameterException(Throwable cause) {
		super(cause);
	}

}
