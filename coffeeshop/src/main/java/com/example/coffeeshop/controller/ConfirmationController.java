package com.example.coffeeshop.controller;

import com.example.coffeeshop.repository.Basket;
import com.example.coffeeshop.repository.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class ConfirmationController {

    Basket basket;
    Order order;

    @RequestMapping("/confirmation")
    public String showCustomerConfirmation(@ModelAttribute("basketItems") Basket basket,
                                           @ModelAttribute("order") Order order) {

        log.info("basket " + basket + "order " + order);
        return "redirect:/";
    }

}
