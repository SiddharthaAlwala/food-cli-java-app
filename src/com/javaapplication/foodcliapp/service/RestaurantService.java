package com.javaapplication.foodcliapp.service;

import com.javaapplication.foodcliapp.exceptions.RestaurantExistsException;
import com.javaapplication.foodcliapp.exceptions.RestaurantNotFoundException;
import com.javaapplication.foodcliapp.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    public List<Restaurant> restaurantList();


    public Restaurant save(Restaurant restaurant) throws RestaurantExistsException;

    public Restaurant findRestaurantById(String id) throws RestaurantNotFoundException;


}
