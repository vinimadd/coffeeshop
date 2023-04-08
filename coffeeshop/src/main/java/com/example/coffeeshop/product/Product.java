package com.example.coffeeshop.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Product {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private String productRegion;

    private int amount;

    private double price;

//    @Column(name="inStock")
//    private boolean inStock;

}
