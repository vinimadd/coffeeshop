package com.example.coffeeshop.service;

import com.example.coffeeshop.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTests {

    @Autowired
    private Customer customer;
    @Autowired
    private CustomerService customerService;

    @Test
    public void canSaveCustomer() {

        Customer mizuki = new Customer(null, "Mizuki", "Koike", "Meandres 12", "Keeko", "mizuki_yeeha@saplu.com", "234445678");
        Customer savedCustomer = customerService.saveCustomer(mizuki);

        assertThat(savedCustomer.getId()).isGreaterThan(0);

    }
}
