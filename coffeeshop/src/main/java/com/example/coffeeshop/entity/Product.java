package com.example.coffeeshop.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_region")
    private String productRegion;

    @Column(name="amount")
    private int amount;

    @Column(name="price")
    private double price;

//    @Column(name="inStock")
//    private boolean inStock;

}
