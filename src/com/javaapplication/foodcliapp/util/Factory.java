package com.javaapplication.foodcliapp.util;

import com.javaapplication.foodcliapp.controller.CustomerController;
import com.javaapplication.foodcliapp.controller.DishController;
import com.javaapplication.foodcliapp.controller.RestaurantController;
import com.javaapplication.foodcliapp.model.Dish;
import com.javaapplication.foodcliapp.repository.CustomerRepository;
import com.javaapplication.foodcliapp.repository.DishRepository;
import com.javaapplication.foodcliapp.repository.RestaurantRepository;
import com.javaapplication.foodcliapp.service.CustomerServiceImpl;
import com.javaapplication.foodcliapp.service.DishServiceImpl;
import com.javaapplication.foodcliapp.service.RestaurantServiceImpl;

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


    public static DishRepository getDishRepository(){
        return new DishRepository();

    }
    public static DishServiceImpl getDishService(){
        return new DishServiceImpl(getDishRepository());
    }

    public static DishController getDishController(){
        return new DishController(getDishService());
    }

    public static RestaurantRepository getRestaurantRepository(){
        return new RestaurantRepository();
    }

    public static RestaurantServiceImpl getRestaurantService(){
        return new RestaurantServiceImpl(getRestaurantRepository());
    }

    public static RestaurantController getRestaurantController(){
        return new RestaurantController(getRestaurantService());
    }
}
