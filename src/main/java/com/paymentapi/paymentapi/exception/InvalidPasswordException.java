package com.paymentapi.paymentapi.exception;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(){
        super("Invalid Password");
    }

}