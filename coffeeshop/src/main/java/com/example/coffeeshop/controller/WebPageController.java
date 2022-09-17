package com.example.coffeeshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebPageController {

    //show homepage
    //show additional info

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/knowCoffee")
    public String coffeePage() {
        return "knowCoffee";
    }


}
