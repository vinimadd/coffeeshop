package com.example.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api")
public class WebPageController {

    //show homepage
    //show additional info

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/knowCoffee")
    public String coffeePage() {
        return "knowCoffee";
    }


}
