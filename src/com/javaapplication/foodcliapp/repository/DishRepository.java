package com.javaapplication.foodcliapp.repository;

import com.javaapplication.foodcliapp.model.Dish;
import com.javaapplication.foodcliapp.util.CsvReader;

import java.util.List;

public class DishRepository {
    private List<Dish> dishesList;

    public DishRepository() {
        CsvReader csvReader = new CsvReader();
        this.dishesList = csvReader.readDishesFromCsv();
    }

    public List<Dish> getAllDishes(){
        return this.dishesList;
    }
}
