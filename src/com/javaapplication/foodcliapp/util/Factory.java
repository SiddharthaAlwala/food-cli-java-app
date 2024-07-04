package com.javaapplication.foodcliapp.util;

import com.javaapplication.foodcliapp.controller.CustomerController;
import com.javaapplication.foodcliapp.repository.CustomerRepository;
import com.javaapplication.foodcliapp.service.CustomerServiceImpl;

public class Factory {
    public static CustomerRepository getCustomerRepository(){
        return new CustomerRepository();
    }

    public static CustomerServiceImpl getCustomerService(){
        return new CustomerServiceImpl(getCustomerRepository());
    }

    public static CustomerController getCustomerController(){
        return new CustomerController(getCustomerService());
    }
}
