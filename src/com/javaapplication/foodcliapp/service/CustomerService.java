package com.javaapplication.foodcliapp.service;

import com.javaapplication.foodcliapp.exceptions.CustomerExistsException;
import com.javaapplication.foodcliapp.model.Customer;

public interface CustomerService {

    public Customer save(Customer customer) throws CustomerExistsException;
}
