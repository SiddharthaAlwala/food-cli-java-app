package com.javaapplication.foodcliapp.exceptions;

public class OrderExistsException extends Exception{
    public OrderExistsException(String message) {
        super(message);
    }
}
