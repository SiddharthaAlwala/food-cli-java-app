package com.javaapplication.foodcliapp;

import com.javaapplication.foodcliapp.repository.CustomerRepository;
import com.javaapplication.foodcliapp.repository.DishRepository;
import com.javaapplication.foodcliapp.repository.RestaurantRepository;
import com.javaapplication.foodcliapp.util.CsvReader;

public class Main {
    public static void main(String[] args) {
        //CsvReader csvReader = new CsvReader();
        //System.out.println(csvReader.reaCustomersFromCsv());
        //System.out.println(csvReader.readDishesFromCsv());
        //System.out.println(csvReader.readRestaurantsFromCsv());
        //CustomerRepository customerRepository = new CustomerRepository();
        //DishRepository dishRepository = new DishRepository();
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        //System.out.println(customerRepository.getAllCustomers());
        //System.out.println(dishRepository.getAllDishes());
        System.out.println(restaurantRepository.getAllRestaurents());
    }
}
