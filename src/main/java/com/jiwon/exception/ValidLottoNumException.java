package com.jiwon.exception;

public class ValidLottoNumException extends RuntimeException {

	public ValidLottoNumException() {
		super();
	}

	public ValidLottoNumException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ValidLottoNumException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidLottoNumException(String message) {
		super(message);
	}

	public ValidLottoNumException(Throwable cause) {
		super(cause);
	}

}
