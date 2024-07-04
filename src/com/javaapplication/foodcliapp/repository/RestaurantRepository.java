package com.javaapplication.foodcliapp.repository;

import com.javaapplication.foodcliapp.model.Restaurant;
import com.javaapplication.foodcliapp.util.CsvReader;

import java.util.List;

public class RestaurantRepository {

    private List<Restaurant> restaurantList;
    public RestaurantRepository(){
        CsvReader csvReader = new CsvReader();
        this.restaurantList = csvReader.readRestaurantsFromCsv();
    }

    public List<Restaurant> getAllRestaurents(){
        return this.restaurantList;
    }
}
