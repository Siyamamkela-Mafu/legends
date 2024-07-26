package com.siyama.legends.exception;

public class DoesNotExistException extends RuntimeException {
    public DoesNotExistException(String object) {
        super(String.format("Invalid %s supplied.", object));
    }
}
