package com.javaapplication.foodcliapp.service;

import com.javaapplication.foodcliapp.exceptions.RestaurantExistsException;
import com.javaapplication.foodcliapp.exceptions.RestaurantNotFoundException;
import com.javaapplication.foodcliapp.model.Restaurant;
import com.javaapplication.foodcliapp.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> restaurantList() {
        return this.restaurantRepository.getAllRestaurents();
    }

    @Override
    public Restaurant save(Restaurant restaurant) throws RestaurantExistsException {
        Optional<Restaurant> byRestaurentId = this.restaurantRepository.findRestaurentById(restaurant.getId());
        if(byRestaurentId.isPresent()){
            System.out.println("Restaurent with given id is already exists"+ restaurant.getId());
        }
        return this.restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant findRestaurantById(String id) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurentById = this.restaurantRepository.findRestaurentById(id);
        if (restaurentById.isEmpty()){
            throw new RestaurantNotFoundException("Restaurant not found with the given Id."+ id);
        }
        return restaurentById.get();
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurentById = this.restaurantRepository.findRestaurentById(restaurant.getId());
        if(restaurentById.isEmpty()){
            throw new RestaurantNotFoundException("Restaurant that you want to update not found");
        }
        return this.restaurantRepository.updateRetaurant(restaurant);

    }


}
