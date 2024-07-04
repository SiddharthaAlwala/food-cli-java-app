package com.javaapplication.foodcliapp.controller;

import com.javaapplication.foodcliapp.exceptions.DishExistsException;
import com.javaapplication.foodcliapp.model.Dish;
import com.javaapplication.foodcliapp.service.DishServiceImpl;

public class DishController {
    private DishServiceImpl dishService;

    public DishController(DishServiceImpl dishService) {
        this.dishService = dishService;
    }

    public Dish save(Dish dish) throws DishExistsException {
        return this.dishService.save(dish);
    }
}
