package com.javaapplication.foodcliapp.util;

import com.javaapplication.foodcliapp.model.Customer;
import com.javaapplication.foodcliapp.model.Dish;
import com.javaapplication.foodcliapp.model.Restaurant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CsvReader {
    /*
    It should read the data from csv files and create a list.
     */
    public List<Customer> readCustomersFromCsv() {
        String customerCsvFilePath = "C:\\Summer Projects\\food-cli-java-app\\data\\customers.csv";
        List<Customer> customerList = new ArrayList<>();

        // try-with-resource
        BufferedReader br;
        String line;
        {
            try {
                br = new BufferedReader(new FileReader(customerCsvFilePath));
                String splitBy = ",";
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(splitBy);
                    Customer customer = new Customer();
                    customer.setId(data[0])
                            .setName(data[1])
                            .setEmail(data[2])
                            .setPassword(data[3]);
                    customerList.add(customer);


                }

            } catch (IOException fileNotFoundException) {
                System.out.println("File Not found in the path : " + customerCsvFilePath);
                fileNotFoundException.printStackTrace();
            }
        }
        return customerList;
    }
    public List<Dish>readDishesFromCsv(){
        String dishCsvFilePath = "C:\\Summer Projects\\food-cli-java-app\\data\\dishes.csv";
        List<Dish> dishList = new ArrayList<>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(dishCsvFilePath));
            br.readLine();
            String dishSplitBy = ",";
            while((line = br.readLine()) != null){
                String[] dishData = line.split(dishSplitBy);
                Dish dish = new Dish();
                dish.setId(dishData[0])
                        .setName(dishData[1])
                        .setDescription(dishData[2])
                        .setPrice(Double.parseDouble(dishData[3]));
                dishList.add(dish);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dishList;
    }
    public List<Restaurant> readRestaurantsFromCsv(){
        String restaurantCsvFilePath = "C:\\Summer Projects\\food-cli-java-app\\data\\restaurants.csv";
        List<Restaurant> restaurantList = new ArrayList<>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(restaurantCsvFilePath));
            br.readLine();
            String restaurantSplitBy = ",";
            while( (line = br.readLine()) != null){
                String[] restaurantData = line.split(restaurantSplitBy);
                Restaurant restaurant = new Restaurant();
                restaurant.setId(restaurantData[0])
                        .setName(restaurantData[1])
                        .setMenu(Collections.singletonList(restaurantData[2]))
                        .setAddress(restaurantData[3]);
                restaurantList.add(restaurant);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return restaurantList;
    }
}
