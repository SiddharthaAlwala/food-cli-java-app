package com.javaapplication.foodcliapp.service;

import com.javaapplication.foodcliapp.exceptions.RestaurentExistsException;
import com.javaapplication.foodcliapp.model.Restaurant;
import com.javaapplication.foodcliapp.repository.RestaurantRepository;

import java.util.Optional;

public class RestaurentServiceImpl implements RestaurentService{
    private RestaurantRepository restaurantRepository;

    public RestaurentServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant save(Restaurant restaurant) throws RestaurentExistsException {
        Optional<Restaurant> byRestaurentId = this.restaurantRepository.findByRestaurentId(restaurant.getId());
        if(byRestaurentId.isPresent()){
            System.out.println("Restaurent with given id is already exists"+ restaurant.getId());
        }
        return this.restaurantRepository.save(restaurant);
    }
}
