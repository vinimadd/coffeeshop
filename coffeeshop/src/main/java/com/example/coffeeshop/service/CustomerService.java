package com.example.coffeeshop.service;

import com.example.coffeeshop.entity.Customer;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface CustomerService {

    List<Customer> showAllCustomers ();

    Customer saveCustomer(Customer customer);

    Customer getCustomer(int id);

    Customer updateCustomer(Customer customer, int id) throws AccountNotFoundException;

    void deleteCustomer(int id) throws AccountNotFoundException;
}
