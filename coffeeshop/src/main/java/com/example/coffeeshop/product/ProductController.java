package com.example.coffeeshop.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/api/v1/products/")
public class ProductController {

//    private final ProductService productService;
//
//    @Autowired
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }


//    // show available coffee products
//    @GetMapping
//    public String showProducts(Model model) {
//
//        List<Product> products = productService.findAll();
//
//        return "products";
//    }

//    @PostMapping
//    public Order addProducts(@RequestBody Order order){
//
////        return orderService.saveOrder(order);
//    }

    // pick coffee products, redirect to current order

}
