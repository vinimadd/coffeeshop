package com.example.coffeeshop.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="product_id")
    private int productId;

    @Column(name="amount")
    private int amount;

    @Column(name="purchase_price")
    private double purchasePrice;
    
}
