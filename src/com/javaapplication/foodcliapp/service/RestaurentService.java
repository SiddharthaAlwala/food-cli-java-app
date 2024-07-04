package com.javaapplication.foodcliapp.service;

import com.javaapplication.foodcliapp.exceptions.RestaurentExistsException;
import com.javaapplication.foodcliapp.model.Restaurant;
import com.javaapplication.foodcliapp.repository.RestaurantRepository;

public interface RestaurentService {

    public Restaurant save(Restaurant restaurant) throws RestaurentExistsException;

}
