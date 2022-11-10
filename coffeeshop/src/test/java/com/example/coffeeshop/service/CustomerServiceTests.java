package com.example.coffeeshop.service;

import com.example.coffeeshop.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CustomerServiceTests {

    @Autowired
    private CustomerService customerService;

    @Test
    public void canSaveCustomer() {

        Customer mizuki = new Customer(null, "Mizuki", "Koike", "Meandres 12", "Keeko", "mizuki_yeeha@saplu.com", "234445678");
        Customer savedCustomer = customerService.saveCustomer(mizuki);

        assertThat(savedCustomer.getId()).isGreaterThan(0);

    }

    @Test
    public void canSaveCustomers() {
        Customer customer1 = new Customer(null, "Kitahara", "Ryuuju", "Abahara 112b", "Nenneko", "kitahara_yeeha@samplu.com", "224346677");
        Customer customer2 = new Customer(null, "Shibahara", "Rizumu", "Uawa 56", "Uzki", "shibahara_yeeha@samplu.com", "123345465");

        Customer savedCustomer1 = customerService.saveCustomer(customer1);
        Customer savedCustomer2 = customerService.saveCustomer(customer2);

        assertThat(savedCustomer1.getId()).isNotEqualTo(savedCustomer2.getId());

    }

    @Test
    public void findCustomerById() {

        Customer mizuki = new Customer(null, "Mizuki", "Koike", "Meandres 12", "Keeko", "mizuki_yeeha@saplu.com", "234445678");

        Customer savedCustomer = customerService.saveCustomer(mizuki);
        Customer foundCustomer = customerService.getCustomer(savedCustomer.getId());

        assertThat(foundCustomer).isEqualTo(savedCustomer);

    }

}
