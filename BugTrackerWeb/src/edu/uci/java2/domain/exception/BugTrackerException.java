package edu.uci.java2.domain.exception;

public class BugTrackerException extends Exception {

	private static final long serialVersionUID = 4874434590051968922L;

	public BugTrackerException() {
		super();
	}

	public BugTrackerException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BugTrackerException(String message, Throwable cause) {
		super(message, cause);
	}

	public BugTrackerException(String message) {
		super(message);
	}

	public BugTrackerException(Throwable cause) {
		super(cause);
	}

}
