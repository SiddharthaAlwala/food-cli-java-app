package com.javaapplication.foodcliapp.controller;

import com.javaapplication.foodcliapp.exceptions.OrderExistsException;
import com.javaapplication.foodcliapp.exceptions.OrderNotFoundException;
import com.javaapplication.foodcliapp.model.Order;
import com.javaapplication.foodcliapp.service.OrderServiceImpl;

import java.util.List;

public class OrderController {

    private OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    public List<Order> getOrdersList(){
        return this.orderService.getOrdersList();
    }

    public Order saveOrder(Order order) throws OrderExistsException {
        return this.orderService.save(order);
    }

    public Order getOrderById(String id) throws OrderNotFoundException {
        return this.orderService.getOrderById(id);
    }
}
