package com.dev.BankService.exception;

public class CustomExceptions extends RuntimeException {
    public CustomExceptions(String message) {
        super(message);
    }
    public CustomExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomExceptions(Throwable cause) {
        super(cause);
    }
}


