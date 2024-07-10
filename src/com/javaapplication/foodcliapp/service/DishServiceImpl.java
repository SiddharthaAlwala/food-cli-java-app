package com.javaapplication.foodcliapp.service;

import com.javaapplication.foodcliapp.exceptions.DishExistsException;
import com.javaapplication.foodcliapp.exceptions.DishNotFoundException;
import com.javaapplication.foodcliapp.model.Dish;
import com.javaapplication.foodcliapp.repository.DishRepository;

import java.util.List;
import java.util.Optional;

public class DishServiceImpl implements DishService{


    private DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> getDishList() {
        return this.dishRepository.getAllDishes();
    }

    @Override
    public Dish save(Dish dish) throws DishExistsException {
        Optional<Dish> byDishId = this.dishRepository.findByDishId(dish.getId());
        if(byDishId.isPresent()){
            System.out.println("Dish already exists: " + dish.getId());
        }

        return this.dishRepository.save(dish);
    }

    @Override
    public Dish getDishById(String id) throws DishNotFoundException {
        Optional<Dish> byDishId = this.dishRepository.findByDishId((id));
        if(byDishId.isEmpty()){
            throw new DishNotFoundException("Dish not found with id: "+ id);
        }
        return byDishId.get();
    }

    @Override
    public void deleteDish(String id) throws DishNotFoundException {
        Optional<Dish> byDishId = this.dishRepository.findByDishId(id);
        if(byDishId.isEmpty()){
            throw new DishNotFoundException("Dish that you want delete with given id now found."+id);
        }
        else{
            this.dishRepository.deletDish(id);
        }
    }
}
