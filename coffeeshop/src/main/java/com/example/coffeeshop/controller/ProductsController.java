package com.example.coffeeshop.controller;

import com.example.coffeeshop.entity.CoffeeProducts;
import com.example.coffeeshop.entity.Basket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class ProductsController {

    // show available coffee products
    // pick coffee products, redirect to current order

    @ModelAttribute
    public void addCoffeeToModel(Model model) {
        List<CoffeeProducts> coffees = Arrays.asList(
                new CoffeeProducts("ELS", "El Salvador", CoffeeProducts.Type.SOUTH_AMERICA),
                new CoffeeProducts("GUA", "Guatemala", CoffeeProducts.Type.SOUTH_AMERICA),
                new CoffeeProducts("HON", "Honduras", CoffeeProducts.Type.SOUTH_AMERICA),
                new CoffeeProducts("COS", "Costa Rica", CoffeeProducts.Type.SOUTH_AMERICA),
                new CoffeeProducts("PAN", "Panama", CoffeeProducts.Type.SOUTH_AMERICA),
                new CoffeeProducts("PER", "Peru", CoffeeProducts.Type.SOUTH_AMERICA),
                new CoffeeProducts("COL", "Colombia", CoffeeProducts.Type.SOUTH_AMERICA),
                new CoffeeProducts("BRA", "Brazil", CoffeeProducts.Type.SOUTH_AMERICA),
                new CoffeeProducts("MEX", "Mexico", CoffeeProducts.Type.SOUTH_AMERICA),
                new CoffeeProducts("RWA", "Rwanda", CoffeeProducts.Type.AFRICA),
                new CoffeeProducts("YEM", "Yemen", CoffeeProducts.Type.AFRICA),
                new CoffeeProducts("UGA", "Uganda", CoffeeProducts.Type.AFRICA),
                new CoffeeProducts("KEN", "Kenya", CoffeeProducts.Type.AFRICA),
                new CoffeeProducts("ETH", "Ethiopia", CoffeeProducts.Type.AFRICA),
                new CoffeeProducts("IND", "India", CoffeeProducts.Type.ASIA),
                new CoffeeProducts("SUM", "Sumatra", CoffeeProducts.Type.ASIA),
                new CoffeeProducts("JAV", "Java", CoffeeProducts.Type.ASIA),
                new CoffeeProducts("NEW", "New Guinea", CoffeeProducts.Type.ASIA),
                new CoffeeProducts("YUN", "Yunnan", CoffeeProducts.Type.ASIA)
        );
        CoffeeProducts.Type[] types = CoffeeProducts.Type.values();

        for (CoffeeProducts.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(coffees, type));
        }
    }

    @GetMapping("/coffeeProducts")
    public String showCoffeeForm(Model model) {
        model.addAttribute("coffeeProducts", new Basket());
        return "coffeeProducts";

    }

    @PostMapping("/processForm")
    public String processCoffeeForm(@Valid @ModelAttribute("coffeeProducts") Basket basket,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "coffeeProducts";
        } else {
            log.info("Picked items: " + basket);
            return "redirect:/orders/current";
        }
    }

    private List<CoffeeProducts> filterByType(List<CoffeeProducts> coffees, CoffeeProducts.Type type) {
        return coffees
                .stream()
                .filter(c -> c.getType().equals(type))
                .collect(Collectors.toList());
    }
}
