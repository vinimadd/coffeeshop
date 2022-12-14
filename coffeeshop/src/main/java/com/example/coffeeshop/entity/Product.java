package com.example.coffeeshop.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

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
