package com.javaapplication.foodcliapp.ui;

import com.javaapplication.foodcliapp.controller.CustomerController;
import com.javaapplication.foodcliapp.controller.DishController;
import com.javaapplication.foodcliapp.controller.RestaurantController;
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
            // enhancing switch statement. This feature added from java 11.
            int input = sc.nextInt();
            switch(input){
                case 1 -> new CustomerMenu().displayMainMenu();
                case 3 -> new RestaurantMenu().displayMainMenu();

                /*case 4:
                    displayDishesMenu();
                    break;
                case 7:
                    System.out.println("Thank you for using out food app, See you again");
                    System.exit(0);


                default:
                    System.out.println("Invalid Input");

                 */
            }
        }

    }

    public void displayMenuHeader(String menuHeader) {
        printDashLine();
        String spaces = new String(new char[70]).replace('\0', ' ');
        System.out.printf("%-70s %-10s %-70s \n", spaces, menuHeader, spaces);
        printDashLine();
    }

    public void printDashLine(){
        String dashesLine = new String(new char[150]).replace('\0', '-');
        System.out.println(dashesLine);
    }


}
