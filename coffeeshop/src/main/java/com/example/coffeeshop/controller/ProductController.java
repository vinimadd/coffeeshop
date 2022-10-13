package com.example.coffeeshop.controller;

import com.example.coffeeshop.entity.Order;
import com.example.coffeeshop.entity.Product;
import com.example.coffeeshop.service.OrderService;
import com.example.coffeeshop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/api")
public class ProductController {

    private ProductService productService;
    private OrderService orderService;

    @Autowired
    public ProductController (ProductService theProductService) {
        productService = theProductService;
    }

    // show available coffee products
    @GetMapping("/products")
    public String showProducts(Model model) {

        List<Product> products = productService.findAll();

        model.addAttribute("products", products);

        return "products";
    }

    @PostMapping("/products")
    public Order addProducts(@RequestBody Order order){

        return orderService.saveOrder(order);
    }

    // pick coffee products, redirect to current order


}
