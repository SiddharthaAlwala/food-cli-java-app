package com.javaapplication.foodcliapp.exceptions;

public class CustomerExistsException extends Exception{

    public CustomerExistsException(String message) {
        super(message);
    }
}
