package com.example.coffeeshop.orders;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/api/v1/order")
public class OrdersController {

    // show current order
    // process current order
    // show current order confirmation, redirect

//    private final OrderService orderService;
//
//    @Autowired
//    public OrderController(OrderService orderService) {
//        this.orderService = orderService;
//    }

//    @GetMapping("/orders/current")
//    public String showOrderForm(Model model) {
//        model.addAttribute("order", new Customer());
//        return "form";
//    }

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
