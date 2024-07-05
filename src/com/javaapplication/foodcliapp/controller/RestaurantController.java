package com.javaapplication.foodcliapp.controller;

import com.javaapplication.foodcliapp.exceptions.RestaurantExistsException;
import com.javaapplication.foodcliapp.exceptions.RestaurantNotFoundException;
import com.javaapplication.foodcliapp.model.Restaurant;
import com.javaapplication.foodcliapp.service.RestaurantServiceImpl;

import java.util.List;

public class RestaurantController {

    private RestaurantServiceImpl restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    public List<Restaurant> getRestaurantList(){
        return this.restaurantService.restaurantList();
    }

    public Restaurant save(Restaurant restaurant) throws RestaurantExistsException {
        return this.restaurantService.save(restaurant);
    }

    public Restaurant findRestaurantById(String id) throws RestaurantNotFoundException{
        return this.restaurantService.findRestaurantById(id);
    }
}
