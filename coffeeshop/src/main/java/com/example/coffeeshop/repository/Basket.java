package com.example.coffeeshop.repository;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@Data
public class Basket {

    @NotNull
    @Size(min = 1, message = "you must pick at least one item")
    private List<String> coffeeOrder;
}
