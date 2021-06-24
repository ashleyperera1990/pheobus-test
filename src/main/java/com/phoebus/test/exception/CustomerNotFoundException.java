package com.phoebus.test.exception;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException() {
        super("Customer Not Found");
    }
}
