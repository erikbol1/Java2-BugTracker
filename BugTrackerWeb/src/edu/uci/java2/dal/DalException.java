package edu.uci.java2.dal;

public class DalException extends Exception {

	private static final long serialVersionUID = -3523182874154247274L;

	public DalException() {
	}

	public DalException(String message) {
		super(message);
	}

	public DalException(Throwable cause) {
		super(cause);
	}

	public DalException(String message, Throwable cause) {
		super(message, cause);
	}

	public DalException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
