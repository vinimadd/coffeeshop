package com.example.coffeeshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    //show customer info
    //show customer orders

    @GetMapping("/customer/{customerId}")
    public String customerInfo() {

        return "customer-info";
    }
}
