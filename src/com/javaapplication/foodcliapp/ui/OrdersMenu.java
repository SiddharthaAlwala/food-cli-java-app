package com.javaapplication.foodcliapp.ui;

import com.javaapplication.foodcliapp.controller.OrderController;
import com.javaapplication.foodcliapp.exceptions.DishNotFoundException;
import com.javaapplication.foodcliapp.exceptions.OrderExistsException;
import com.javaapplication.foodcliapp.exceptions.OrderNotFoundException;
import com.javaapplication.foodcliapp.exceptions.RestaurantNotFoundException;
import com.javaapplication.foodcliapp.model.Customer;
import com.javaapplication.foodcliapp.model.Dish;
import com.javaapplication.foodcliapp.model.Order;
import com.javaapplication.foodcliapp.model.Restaurant;
import com.javaapplication.foodcliapp.service.CustomerService;
import com.javaapplication.foodcliapp.service.DishService;
import com.javaapplication.foodcliapp.service.RestaurantService;
import com.javaapplication.foodcliapp.util.Factory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrdersMenu extends Menu {

    private final OrderController orderController;

    public OrdersMenu() {
        this.orderController = Factory.getOrderController();
    }

    @Override
    public void displayMainMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                displayMenuHeader("WELCOME TO ORDERS SECTION");
                System.out.println();
                System.out.println("Please select the option !");
                System.out.println("--------------------------");
                System.out.println("1. Place New Order");
                System.out.println("2. Search Order");
                System.out.println("3. View All Orders");
                System.out.println("4. Exit");
                System.out.println("Please enter your choice (1-4)");
                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> newOrderForm();
                    case 2 -> searchOrderForm();
                    case 3 -> ordersList();
                    case 4 -> {
                        System.out.println("Thank you , See you again !");
                        super.displayMainMenu();
                    }
                    default -> System.out.println("Invalid Input. Please enter the valid input from(1-4)");
                }
            }
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            displayMainMenu();
        }

    }

    private void ordersList() {
        List<Order> ordersList = this.orderController.getOrdersList();
        displayMenuHeader("All Order Details");
        System.out.printf("%-10s %-20s %-30s %-60s %-20s %-10s\n", "Id", "Customer Name", "Restaurant Name", "Items", "Order Date", "Price");
        printDashLine();

        ordersList.forEach(order -> {
            String dishNames = order.getDishes().stream().map(Dish::getName).collect(Collectors.joining(","));
            System.out.printf("%-10s %-20s %-30s %-60s %-20s %-10s\n\n", order.getId(), order.getCustomer().getName(), order.getRestaurant().getName(), dishNames, order.getOrderDate(), order.getTotalPrice());
        });
        System.out.println("\n\n");
    }

    private void searchOrderForm() {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to search for Order\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            Order order = orderController.getOrderById(id);
            displayOrderDetails(order);
        } catch (OrderNotFoundException e) {
            System.out.println(e.getMessage());
            displayMainMenu();
        }
    }

    private void displayOrderDetails(Order order) {
        String dishNames = order.getDishes().stream().map(Dish::getName).collect(Collectors.joining(","));
        displayMenuHeader("Order Details");
        System.out.printf("%-10s %-20s %-30s %-60s %-20s %-10s\n", "Id", "Customer Name", "Restaurant Name", "Items","Order Date","Price");
        printDashLine();
        System.out.printf("%-10s %-20s %-30s %-60s %-20s %-10s\n\n", order.getId(), order.getCustomer().getName(), order.getRestaurant().getName(), dishNames,order.getOrderDate(),String.format("$%.2f", order.getTotalPrice()));


    }

    private void newOrderForm() throws DishNotFoundException {

        Customer loggedInCustomer = null;
        Restaurant restaurant = null;
        List<Dish> dishList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(System.in);
            CustomerService customerService = Factory.getCustomerService();
            RestaurantService restaurantService = Factory.getRestaurantService();
            DishService dishService = Factory.getDishService();
            loggedInCustomer = customerService.getCurrentLoggedInCustomer();
            if(loggedInCustomer != null )
                System.out.println("Hello , " + loggedInCustomer.getName());
            while (loggedInCustomer == null) {
                System.out.println("Please login to place an order");
                new CustomerMenu().customerLoginForm();
                loggedInCustomer = customerService.getCurrentLoggedInCustomer();
            }

            System.out.println("Enter Order Id :");
            String id = scanner.nextLine();

            while (restaurant == null) {
                new RestaurantMenu().displayRestaurants();
                printDashLine();
                System.out.println("Choose the Restaurant Id (Ex: R08 )");
                String restaurantId = scanner.nextLine();
                restaurant = restaurantService.findRestaurantById(restaurantId);
            }
            char addMoreItems = 'Y';
            while (addMoreItems == 'Y') {
                new RestaurantMenu().displayMenuItems(restaurant.getId());
                printDashLine();
                System.out.println("Enter the Dish Id (Ex : D001 )");
                String dishId = scanner.nextLine();
                Dish selectedDish = dishService.getDishById(dishId);
                dishList.add(selectedDish);
                System.out.println("One Dish is added successfully : " + selectedDish.getName());
                System.out.println("Do you want to add more dishes (Y/N)");
                addMoreItems = scanner.nextLine().charAt(0);
            }


            double orderPrice = calculateOrderTotalPrice(dishList);
            LocalDate orderDate = LocalDate.now();



            Order order = new Order();
            order.setId(id)
                    .setCustomer(loggedInCustomer)
                    .setRestaurant(restaurant)
                    .setDishes(dishList)
                    .setTotalPrice(orderPrice)
                    .setOrderDate(orderDate);

            Order placedOrder = orderController.saveOrder(order);
            if(placedOrder != null)
                System.out.println("Order Placed Successfully with the following details");

            displayOrderDetails(placedOrder);

        } catch (RestaurantNotFoundException | OrderExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    private double calculateOrderTotalPrice(List<Dish> dishList) {
        return dishList.stream().mapToDouble(Dish::getPrice).sum();
    }


}
