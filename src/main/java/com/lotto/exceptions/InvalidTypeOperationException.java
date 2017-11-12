package com.lotto.exceptions;

public class InvalidTypeOperationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidTypeOperationException(String msg) {
		super(msg);
	}
}
