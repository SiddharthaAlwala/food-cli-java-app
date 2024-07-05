package com.javaapplication.foodcliapp.controller;

import com.javaapplication.foodcliapp.exceptions.DishExistsException;
import com.javaapplication.foodcliapp.model.Dish;
import com.javaapplication.foodcliapp.service.DishServiceImpl;

import java.util.List;

public class DishController {
    private DishServiceImpl dishService;

    public DishController(DishServiceImpl dishService) {
        this.dishService = dishService;
    }
    public List<Dish> getDishesList(){
        return this.dishService.getDishList();

    }

    public Dish save(Dish dish) throws DishExistsException {
        return this.dishService.save(dish);
    }


}
