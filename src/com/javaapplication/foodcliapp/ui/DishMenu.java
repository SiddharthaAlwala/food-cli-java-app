package com.javaapplication.foodcliapp.ui;

import com.javaapplication.foodcliapp.controller.DishController;
import com.javaapplication.foodcliapp.exceptions.DishExistsException;
import com.javaapplication.foodcliapp.exceptions.DishNotFoundException;
import com.javaapplication.foodcliapp.model.Dish;
import com.javaapplication.foodcliapp.util.Factory;

import java.util.List;
import java.util.Scanner;

public class DishMenu extends Menu{
    private DishController dishController;

    public DishMenu() {
        this.dishController = Factory.getDishController();
    }

    @Override
    public void displayMainMenu(){
        try{
            Scanner sc = new Scanner(System.in);
            while(true){
                displayMenuHeader("Welcome to Dishes Section.");
                System.out.println();
                System.out.println("Please select the option !");
                System.out.println("--------------------------");
                System.out.println("1. Add New Dish");
                System.out.println("2. View All Dish Items");
                System.out.println("3. Search Dish");
                System.out.println("4. Update Dish ");
                System.out.println("5. Delete Dish");
                System.out.println("6. Exit");

                System.out.println("Please enter your choice (1-6)");
                int input = sc.nextInt();
                switch(input){
                    case 1-> newDIshForm();
                    case 2-> displayDishes();
                    case 3-> searchDishForm();
                    case 4-> updateDishForm();
                    case 5-> deleteDishForm();
                    case 6 -> {
                        System.out.println("Thank you , See you again !");
                        super.displayMainMenu();
                    }
                    default -> System.out.println("Invalid Input. Please enter the valid input from(1-7)");
                }
            }

        }catch (Exception e){
            System.out.println("Internal error occured. Please try again");
            displayMainMenu();
        }
    }



    public void newDIshForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the following details\n");
        System.out.println("Enter Id");
        String id = scanner.nextLine();
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        System.out.println("Enter Description");
        String description = scanner.nextLine();
        System.out.println("Enter Price");
        double price = scanner.nextDouble();

        Dish dish = new Dish();
        dish.setName(name)
                .setDescription(description)
                .setPrice(price);

        try {
            Dish saveDish = this.dishController.save(dish);
            displayDish(saveDish);
        } catch (DishExistsException e) {
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("Internal error ocured.");
            newDIshForm();
        }

    }
    public void displayDishes(){
        List<Dish> dishesList = this.dishController.getDishesList();
        String dashesLine = new String(new char[150]).replace('\0', '-');
        displayMenuHeader("Dish Items");
        System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
        System.out.println(dashesLine);
        dishesList.forEach(dish -> {
            System.out.printf("%-10s %-30s %-80s %-10s\n", dish.getId(), dish.getName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));
        });
    }

    public void searchDishForm(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the details of the dish that you want to search\n");
        System.out.println("Enter the name of the dish name: ");
        String dishName = sc.nextLine();
        try {
            Dish dish = this.dishController.getDishByName(dishName);
            displayDish(dish);
        } catch (DishNotFoundException e) {
            System.out.println(e.getMessage());
            displayMainMenu();
        }

    }

    public void updateDishForm(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Update entering the following details\n");
        System.out.println("Enter Dish Id");
        String id = scanner.nextLine();
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        System.out.println("Enter Description");
        String description = scanner.nextLine();
        System.out.println("Enter Price");
        double price = scanner.nextDouble();
        Dish dish = new Dish();
        dish.setId(id)
                .setName(name)
                .setDescription(description)
                .setPrice(price);

        try {
            Dish updateDish = this.dishController.updateDish(dish);
            System.out.println("Dish updated succesfully");
            displayDish(updateDish);

        } catch (DishNotFoundException e) {
            System.out.println(e.getMessage());
        } catch(Exception e){
            System.out.println("Intrenal error occured");
            displayMainMenu();
        }
    }

    public void deleteDishForm(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to delete the Dish\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            dishController.deleteDish(id);
            System.out.println("Dish Deleted Successfully");
        } catch (DishNotFoundException e) {
            System.out.println(e.getMessage());
            displayMainMenu();
        }
    }


    public void displayDish(Dish dish) {
        displayMenuHeader("Dish Details");
        System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
        printDashLine();
        System.out.printf("%-10s %-30s %-80s %-10s\n", dish.getId(), dish.getName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));

    }
}
