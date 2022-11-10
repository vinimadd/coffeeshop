package com.example.coffeeshop.controller;

import com.example.coffeeshop.entity.Customer;
import com.example.coffeeshop.service.CustomerService;
import com.example.coffeeshop.service.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Controller
@RequestMapping("/api")
public class CustomerController {

    //show customer info
    //show customer orders

    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }


    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("customer", new Customer());
        return "form";
    }

    @PostMapping("/form")
    public String addCustomer(@Valid Customer customer, Errors errors) {
        Customer saveCustomer = null;
        if (!errors.hasErrors()) {
            saveCustomer = service.saveCustomer(customer);
            return "redirect:home";
        }
        return "form";
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> showAllCustomers(){

        List<Customer> myCustomers = service.showAllCustomers();

        if (myCustomers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }

    @GetMapping("customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) {

        try {
            Customer customer = service.getCustomer(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {

        try {
        Customer updateCustomer = service.updateCustomer(customer, id);

        return new ResponseEntity<>(updateCustomer,HttpStatus.OK);

        } catch (AccountNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/customers/{id}")
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
