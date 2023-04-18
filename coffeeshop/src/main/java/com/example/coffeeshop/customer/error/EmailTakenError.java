package com.example.coffeeshop.customer.error;

public class EmailTakenError extends RuntimeException {
    public EmailTakenError() {
    }

    public EmailTakenError(String message) {
        super(message);
    }

    public EmailTakenError(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailTakenError(Throwable cause) {
        super(cause);
    }

    public EmailTakenError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
