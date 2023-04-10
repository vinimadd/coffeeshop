package com.example.coffeeshop.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository) {
        return args -> {
            Customer mizuki = new Customer(1L, "Mizuki", "Koike", "mizuki@examplu.com", "22-987-234", "Oak Street 2", "Oakland", "456-23");
            Customer brianne = new Customer(2L, "Brianne", "Newman", "brianne@examplu.com", "23-567-224", "Blooming Street 345", "Hawthorne", "675-44");
            repository.saveAll(List.of(mizuki, brianne));
        };
    }
}
