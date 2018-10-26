package com.zingoworks.lotto.exception;

public class DuplicateLottoNumberException extends RuntimeException {
    public DuplicateLottoNumberException() {
    }

    public DuplicateLottoNumberException(String message) {
        super(message);
    }
}
