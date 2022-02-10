package com.example.demo.constant;

public enum OrderState {
    COMPLETE("Complete"),
    PENDING("Pending");

    private final String message;

    OrderState(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
