package com.example.coffeeshop.controller;

import com.example.coffeeshop.repository.Basket;
import com.example.coffeeshop.repository.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/current")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "customerForm";
    }

    @PostMapping("/processForm")
    public String processOrderForm(@Valid @ModelAttribute("order") Order orderData,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customerForm";
        } else {
            log.info("order " + orderData);
            return "customerConfirmation";
        }
    }

}
