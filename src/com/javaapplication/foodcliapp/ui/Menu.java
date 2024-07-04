package com.javaapplication.foodcliapp.ui;

import com.javaapplication.foodcliapp.controller.CustomerController;
import com.javaapplication.foodcliapp.controller.DishController;
import com.javaapplication.foodcliapp.exceptions.CustomerExistsException;
import com.javaapplication.foodcliapp.model.Customer;
import com.javaapplication.foodcliapp.model.Dish;
import com.javaapplication.foodcliapp.util.Factory;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public void displayMainMenu(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("       Welcome to Food App      ");
            System.out.println();
            System.out.println("Please select the option");
            System.out.println("-------------------------");
            System.out.println("1. Register (New Customer");
            System.out.println("2. Login (Existing Customer");
            System.out.println("3. View Restaurants");
            System.out.println("4. View menu");
            System.out.println("5. Place Order");
            System.out.println("6. View Orders");
            System.out.println("7. Exit");

            System.out.println("Please enter your option(1-7)");

            int input = sc.nextInt();
            switch(input){
                case 1:
                    displayRegisterMenu();
                    break;
                case 4:
                    displayDishesMenu();
                    break;
                case 7:
                    System.out.println("Thank you for using out food app, See you again");
                    System.exit(0);
                default:
                    System.out.println("Invalid Input");
            }
        }

    }

    private void displayDishesMenu() {
        DishController dishController = Factory.getDishController();
        //System.out.println(dishController.getDishesList());
        List<Dish> dishList = dishController.getDishesList();
        System.out.println("Id          Name            Descrption          Price");
        System.out.println("-----------------------------------------------------");
        dishList.forEach(dish ->
                        System.out.println(dish.getId()+ "          " +dish.getName() + "           " + dish.getDescription() + "           " +dish.getPrice())
                );

    }

    private void displayRegisterMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please register by entering the following details\n");
        System.out.println("Enter Id");
        String id = sc.nextLine();
        System.out.println("Enter your name");
        String name = sc.nextLine();
        System.out.println("Enter your email");
        String email = sc.nextLine();
        System.out.println("Enter your password ");
        String password = sc.nextLine();

        Customer customer = new Customer();
        customer.setId(id)
                .setName(name)
                .setEmail(email)
                .setPassword(password);


        CustomerController customerController = Factory.getCustomerController();

        try{
            Customer saveCustomer = customerController.save(customer);
            if(saveCustomer != null){
                System.out.println("customer Registration successful");
                System.out.println("Details");
                System.out.println("Id: "+customer.getId());
                System.out.println("name: "+customer.getName());
                System.out.println("email: "+customer.getEmail());
                System.out.println("password: "+customer.getPassword());
            }
            else{
                System.out.println("Something went wrong. please try again");
                displayRegisterMenu();
            }
        } catch (CustomerExistsException e) {
            System.out.println(e.getMessage());
            System.out.println("Please login using main menu");
            displayMainMenu();
        }

    }
}
