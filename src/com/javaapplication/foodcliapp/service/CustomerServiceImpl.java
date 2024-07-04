package com.javaapplication.foodcliapp.service;

import com.javaapplication.foodcliapp.exceptions.CustomerExistsException;
import com.javaapplication.foodcliapp.model.Customer;
import com.javaapplication.foodcliapp.repository.CustomerRepository;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{


    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) throws CustomerExistsException {

        // if customer(id, name, email) already exists then throw CustomerexistsException.
        // else save customer in the repository.
        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getId());
        if(customerById.isPresent()){
            throw new CustomerExistsException(("Customer with the given id already exists: " + customer.getId()));
        }
        return this.customerRepository.save(customer);
    }
}