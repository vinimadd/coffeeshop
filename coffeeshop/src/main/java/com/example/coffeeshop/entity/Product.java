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

    public Product () {}

    public Product(int id, String productName, String productRegion, int amount, double price) {
        this.id = id;
        this.productName = productName;
        this.productRegion = productRegion;
        this.amount = amount;
        this.price = price;
//        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productRegion='" + productRegion + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
