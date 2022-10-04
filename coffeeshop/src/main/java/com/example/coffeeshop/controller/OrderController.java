package com.example.coffeeshop.controller;

import com.example.coffeeshop.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class OrderController {

    // show current order
    // process current order
    // show current order confirmation, redirect

    @GetMapping("/orders/current")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Customer());
        return "customerForm";
    }

//    @PostMapping("/orders/processForm")
//    public String processOrderForm(@Valid @ModelAttribute("order") Order orderData,
//                                   BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "customerForm";
//        } else {
//            log.info("order " + orderData);
//            return "customerConfirmation";
//        }
//    }

//    @GetMapping("/orders/confirmation")
//    public String showCustomerConfirmation(@ModelAttribute("basketItems") Basket basket,
//                                           @ModelAttribute("order") Order order) {
//
//        log.info("basket " + basket + "order " + order);
//        return "redirect:/";
//    }

}
