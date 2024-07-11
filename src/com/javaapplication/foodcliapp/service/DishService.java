package com.javaapplication.foodcliapp.service;

import com.javaapplication.foodcliapp.exceptions.DishExistsException;
import com.javaapplication.foodcliapp.exceptions.DishNotFoundException;
import com.javaapplication.foodcliapp.model.Dish;

import java.util.List;

public interface DishService  {

    public List<Dish> getDishList();

    public Dish save(Dish dish) throws DishExistsException;

    public Dish getDishById(String id) throws DishNotFoundException;

    public Dish getDishByName(String name) throws DishNotFoundException;

    public Dish updateDish(Dish dish) throws DishNotFoundException;

    public void deleteDish(String id) throws  DishNotFoundException;
}
