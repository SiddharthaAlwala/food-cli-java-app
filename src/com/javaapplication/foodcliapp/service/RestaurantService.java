package com.javaapplication.foodcliapp.service;

import com.javaapplication.foodcliapp.exceptions.RestaurantExistsException;
import com.javaapplication.foodcliapp.model.Restaurant;

public interface RestaurantService {

    public Restaurant save(Restaurant restaurant) throws RestaurantExistsException;

}
