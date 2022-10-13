package com.example.coffeeshop.controller;

import com.example.coffeeshop.entity.Customer;
import com.example.coffeeshop.service.CustomerService;
import com.example.coffeeshop.service.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Controller
@RequestMapping("/api/customers")
public class CustomerController {

    //show customer info
    //show customer orders

    @Autowired
    private CustomerService service;

    @GetMapping
    public ResponseEntity<List<Customer>> showAllCustomers(){

        List<Customer> myCustomers = service.showAllCustomers();

        if(myCustomers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer saveCustomer = service.saveCustomer(customer);

        return new ResponseEntity<>(saveCustomer, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) {

        try {
            Customer customer = service.getCustomer(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {

        try {
        Customer updateCustomer = service.updateCustomer(customer, id);

        return new ResponseEntity<>(updateCustomer,HttpStatus.OK);

        } catch (AccountNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") int id){

        try {
            service.deleteCustomer(id);
            return ResponseEntity.noContent().build();
        } catch (AccountNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/customer/{customerId}")
//    public String customerInfo() {
//
//        return "customer-info";
//    }
}
