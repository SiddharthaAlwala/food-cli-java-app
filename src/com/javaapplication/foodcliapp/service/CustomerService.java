package com.javaapplication.foodcliapp.service;

import com.javaapplication.foodcliapp.exceptions.CustomerExistsException;
import com.javaapplication.foodcliapp.exceptions.CustomerNotFoundException;
import com.javaapplication.foodcliapp.model.Customer;

import java.util.List;

public interface CustomerService {

    public Customer save(Customer customer) throws CustomerExistsException;

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(String id) throws CustomerNotFoundException;
}
