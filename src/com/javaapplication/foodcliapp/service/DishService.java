package com.javaapplication.foodcliapp.service;

import com.javaapplication.foodcliapp.exceptions.DishExistsException;
import com.javaapplication.foodcliapp.model.Dish;

public interface DishService  {

    public Dish save(Dish dish) throws DishExistsException;
}
