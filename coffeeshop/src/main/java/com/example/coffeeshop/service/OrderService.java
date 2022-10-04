package com.example.coffeeshop.service;

import com.example.coffeeshop.entity.Order;
import com.example.coffeeshop.entity.OrderDetails;

import java.util.List;


public interface OrderService {

    public List<Order> findAll();

}
