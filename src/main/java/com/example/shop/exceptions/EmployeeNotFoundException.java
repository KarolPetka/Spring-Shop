package com.example.shop.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }

    public EmployeeNotFoundException(String message,Throwable cause) {
        super(message,cause);
    }
}
