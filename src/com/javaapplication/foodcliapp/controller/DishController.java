package com.javaapplication.foodcliapp.controller;

import com.javaapplication.foodcliapp.exceptions.DishExistsException;
import com.javaapplication.foodcliapp.exceptions.DishNotFoundException;
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

    public Dish getDishById(String id) throws DishNotFoundException{
        return this.dishService.getDishById(id);
    }

    public Dish getDishByName(String name) throws DishNotFoundException{
        return this.dishService.getDishByName(name);
    }

    public Dish updateDish(Dish dish) throws DishNotFoundException{
        return this.dishService.updateDish(dish);
    }

    public void deleteDish(String id) throws DishNotFoundException{
        this.dishService.deleteDish(id);
    }
}
