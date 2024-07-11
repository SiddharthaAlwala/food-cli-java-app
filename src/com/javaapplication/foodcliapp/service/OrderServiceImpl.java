package com.javaapplication.foodcliapp.service;

import com.javaapplication.foodcliapp.exceptions.OrderExistsException;
import com.javaapplication.foodcliapp.exceptions.OrderNotFoundException;
import com.javaapplication.foodcliapp.model.Order;
import com.javaapplication.foodcliapp.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public List<Order> getOrdersList() {
        return this.orderRepository.getOrderList();
    }

    @Override
    public Order save(Order order) throws OrderExistsException {
        Optional<Order> orderById = this.orderRepository.findOrderById(order.getId());
        if(orderById.isPresent())
            throw new OrderExistsException("Order Already Exists with this Id : " + order.getId());
        return this.orderRepository.save(order);
    }

    @Override
    public Order getOrderById(String id) throws OrderNotFoundException {
        Optional<Order> orderById = this.orderRepository.findOrderById(id);
        if(orderById.isEmpty())
            throw new OrderNotFoundException("Order Not Found with Id : " + id);
        return orderById.get();
    }
}
