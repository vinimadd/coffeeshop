package com.example.coffeeshop.order;

import com.example.coffeeshop.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Long customerId, List<Product> products) {
        int quantity = products.size();
        LocalDateTime purchaseTime = LocalDateTime.now();
        Order order = new Order(null, customerId, 1L, quantity, purchaseTime, products);
        return orderRepository.save(order);
    }

    public Optional<Order> getOrder(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getAllOrdersByCustomerId(Long customerId) {
        return null;
    }
}
