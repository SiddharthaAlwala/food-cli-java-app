package com.javaapplication.foodcliapp.controller;

import com.javaapplication.foodcliapp.exceptions.CustomerExistsException;
import com.javaapplication.foodcliapp.exceptions.CustomerNotFoundException;
import com.javaapplication.foodcliapp.model.Customer;
import com.javaapplication.foodcliapp.service.CustomerServiceImpl;

import java.util.List;

public class CustomerController {

    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    public Customer save(Customer customer) throws CustomerExistsException {
        return this.customerService.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return this.customerService.getAllCustomers();
    }

    public Customer findCustomerById(String id) throws CustomerNotFoundException{
        return this.customerService.getCustomerById(id);
    }

    public Customer findCustomerByEmail(String email) throws CustomerNotFoundException{
        return this.customerService.getCustomerByEmail(email);
    }

    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
        return this.customerService.updateCustomer(customer);
    }

    public void deleteCustomer(String id) throws CustomerNotFoundException{
         this.customerService.deleteCustomer(id);
    }

    public Customer validateLogin(String email, String password) throws CustomerNotFoundException{
        Customer customer = this.customerService.validateCustomerLogin(email, password);
        if(customer != null)
            this.customerService.setCurrentLoggedInCustomer(customer);
        return customer;
    }

    public Customer currentLoggedInCustomer(){
        return this.customerService.getCurrentLoggedInCustomer();
    }


}
