package com.example.coffeeshop.service;

import com.example.coffeeshop.entity.Order;

import java.util.List;
import java.util.Optional;


public interface OrderService {

    Order saveOrder(Order order);

    Optional<Order> getOrder(int orderId);

    List<Order> getAllOrdersByCustomerId(int customerId);


}
