package com.paymentapi.paymentapi.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
    super(message);
    }
}