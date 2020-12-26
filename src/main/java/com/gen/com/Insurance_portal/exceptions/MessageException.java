package com.gen.com.Insurance_portal.exceptions;

public class MessageException extends RuntimeException {
    private String message;

    public MessageException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}

