package com.example.coffeeshop.repository;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@RequiredArgsConstructor
public class CoffeeProducts {

    private final String id;
    private final String name;
    private final Type type;

    public static  enum Type {
        SOUTH_AMERICA, ASIA, AFRICA
    }

}
