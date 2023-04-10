package com.example.coffeeshop.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/api/v1/customer/")
public class CustomerController {

//    private final CustomerService customerService;
//
//    @Autowired
//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }

//    @PostMapping
//    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
//        try {
//            Customer addCustomer = customerService.saveCustomer(customer);
//            return new ResponseEntity<>(addCustomer, HttpStatus.OK);
//
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().build();
//        }
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Customer>> showAllCustomers(){
//        List<Customer> myCustomers = customerService.showAllCustomers();
//
//        if (myCustomers.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {
//        try {
//            Customer customer = customerService.getCustomer(id);
//            return new ResponseEntity<>(customer, HttpStatus.OK);
//        } catch (NoSuchElementException ex) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
//        try {
//        Customer updateCustomer = customerService.updateCustomer(customer, id);
//        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
//
//        } catch (AccountNotFoundException ex) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id){
//        try {
//            customerService.deleteCustomer(id);
//            return ResponseEntity.noContent().build();
//        } catch (AccountNotFoundException ex) {
//            return ResponseEntity.notFound().build();
//        }
//    }

}
