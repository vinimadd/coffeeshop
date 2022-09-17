package com.example.coffeeshop.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

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
