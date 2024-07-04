package com.javaapplication.foodcliapp.controller;

import com.javaapplication.foodcliapp.exceptions.RestaurantExistsException;
import com.javaapplication.foodcliapp.model.Restaurant;
import com.javaapplication.foodcliapp.service.RestaurantServiceImpl;

public class RestaurantController {

    private RestaurantServiceImpl restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    public Restaurant save(Restaurant restaurant) throws RestaurantExistsException {
        return this.restaurantService.save(restaurant);
    }
}
