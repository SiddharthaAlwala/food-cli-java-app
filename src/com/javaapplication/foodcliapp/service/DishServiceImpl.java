package com.javaapplication.foodcliapp.service;

import com.javaapplication.foodcliapp.exceptions.DishExistsException;
import com.javaapplication.foodcliapp.model.Dish;
import com.javaapplication.foodcliapp.repository.DishRepository;

import java.util.Optional;

public class DishServiceImpl implements DishService{


    private DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Dish save(Dish dish) throws DishExistsException {
        Optional<Dish> byDishId = this.dishRepository.findByDishId(dish.getId());
        if(byDishId.isPresent()){
            System.out.println("Dish already exists: " + dish.getId());
        }

        return this.dishRepository.save(dish);
    }
}
