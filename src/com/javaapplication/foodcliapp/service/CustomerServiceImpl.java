package com.javaapplication.foodcliapp.service;

import com.javaapplication.foodcliapp.exceptions.CustomerExistsException;
import com.javaapplication.foodcliapp.exceptions.CustomerNotFoundException;
import com.javaapplication.foodcliapp.model.Customer;
import com.javaapplication.foodcliapp.repository.CustomerRepository;

import java.util.List;
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

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.getAllCustomers();
    }

    @Override
    public Customer getCustomerById(String id) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(id);
        if(customerById.isEmpty()){
            throw new CustomerNotFoundException("Customer with the given id is not found.");
        }
        return customerById.get();
    }

    @Override
    public Customer getCustomerByEmail(String email) throws CustomerNotFoundException {

        Optional<Customer> customerByEmail = this.customerRepository.findCustomerByEmail(email);
        if(customerByEmail.isEmpty()){
            throw new CustomerNotFoundException("Customer with the given email is not found" + email);

        }
        return customerByEmail.get();
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getId());
        if (customerById.isEmpty()){
            throw new CustomerNotFoundException("Customer with the given id is not present");
        }
        return this.customerRepository.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(String id) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(id);
        if(customerById.isEmpty()){
            throw new CustomerNotFoundException("Customer is not present with the given id to delete" +id);

        }
        else
            this.customerRepository.deleteCustomer(customerById.get());
    }


}
