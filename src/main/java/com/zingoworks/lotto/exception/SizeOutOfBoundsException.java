package com.zingoworks.lotto.exception;

public class SizeOutOfBoundsException extends RuntimeException {
    public SizeOutOfBoundsException() {
    }

    public SizeOutOfBoundsException(String message) {
        super(message);
    }
}
