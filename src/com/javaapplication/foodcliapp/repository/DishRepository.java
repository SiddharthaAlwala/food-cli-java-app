package com.javaapplication.foodcliapp.repository;

import com.javaapplication.foodcliapp.model.Dish;
import com.javaapplication.foodcliapp.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class DishRepository {
    private List<Dish> dishesList;

    public DishRepository() {
        CsvReader csvReader = new CsvReader();
        this.dishesList = csvReader.readDishesFromCsv();
    }

    public List<Dish> getAllDishes(){
        return this.dishesList;
    }

    public Dish save(Dish dish){
        this.dishesList.add(dish);
        return dish;

    }

    public Optional<Dish> findByDishId(String id) {
        return this.dishesList.stream().filter(dish -> dish.getId().equals(id)).findFirst();
    }


}
