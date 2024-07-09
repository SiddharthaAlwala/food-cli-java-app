package com.javaapplication.foodcliapp.repository;

import com.javaapplication.foodcliapp.model.Customer;
import com.javaapplication.foodcliapp.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {


    private List<Customer> customerList;

    public CustomerRepository() {
        CsvReader csvReader = new CsvReader();
        this.customerList = csvReader.readCustomersFromCsv();
    }

    public List<Customer>getAllCustomers(){
        return this.customerList;
    }

    public Customer save(Customer customer){
        this.customerList.add(customer);
        return customer;
    }

    public Optional<Customer> findCustomerById( String id){
        return this.customerList.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }

    public Optional<Customer> findCustomerByEmail(String email){
        return this.customerList.stream().filter(customer -> customer.getEmail().equals(email)).findFirst();
    }

    public Customer updateCustomer(Customer customerToBeUpdate){
        Optional<Customer> updateCustomer = this.customerList.stream().filter(customer -> customer.getId().equals(customerToBeUpdate.getId())).findFirst()
                .map(customer ->{
                            customer.setName(customerToBeUpdate.getName())
                                    .setEmail(customerToBeUpdate.getEmail())
                                    .setPassword(customerToBeUpdate.getPassword());

                            return customer;
                });
                 return updateCustomer.orElse(null);

    }

    public void deleteCustomer(Customer customer){
         this.customerList.remove(customer);

    }

    public Optional<Customer> findByEmailAndPassword(String email, String password){
        return this.customerList.stream().filter(customer -> customer.getEmail().equalsIgnoreCase(email) && customer.getPassword().equals(password)).findFirst();
    }
}
