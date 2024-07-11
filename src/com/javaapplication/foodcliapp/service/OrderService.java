package com.javaapplication.foodcliapp.service;

import com.javaapplication.foodcliapp.exceptions.OrderExistsException;
import com.javaapplication.foodcliapp.exceptions.OrderNotFoundException;
import com.javaapplication.foodcliapp.model.Order;

import java.util.List;

public interface OrderService {

    public List<Order> getOrdersList();
    public Order getOrderById(String id) throws OrderNotFoundException;
    public Order save(Order order) throws OrderExistsException;
}
