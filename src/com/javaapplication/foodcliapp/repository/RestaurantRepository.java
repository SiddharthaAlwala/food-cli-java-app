package com.javaapplication.foodcliapp.repository;

import com.javaapplication.foodcliapp.model.Restaurant;
import com.javaapplication.foodcliapp.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class RestaurantRepository {

    private List<Restaurant> restaurantList;
    public RestaurantRepository(){
        CsvReader csvReader = new CsvReader();
        this.restaurantList = csvReader.readRestaurantsFromCsv();
    }

    public List<Restaurant> getAllRestaurents(){
        return this.restaurantList;
    }
    public Restaurant save(Restaurant restaurant){
        this.restaurantList.add(restaurant);
        return restaurant;
    }

    public Optional<Restaurant> findRestaurentById(String id){
        return this.restaurantList.stream().filter(restaurant -> restaurant.getId().equals(id)).findFirst();
    }
}
