package com.jiwon.exception;

public class ValidStringNumException extends RuntimeException {

	public ValidStringNumException() {
		super();
	}

	public ValidStringNumException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ValidStringNumException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidStringNumException(String message) {
		super(message);
	}

	public ValidStringNumException(Throwable cause) {
		super(cause);
	}

}
