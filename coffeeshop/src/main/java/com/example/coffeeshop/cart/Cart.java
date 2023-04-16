package com.example.coffeeshop.cart;

import com.example.coffeeshop.orders.Orders;
import com.example.coffeeshop.product.Product;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;

@Entity(name = "Cart")
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "total_cost", nullable = false)
    private BigInteger totalCost;

    @OneToMany(mappedBy = "cart")
    private Set<Product> products;

    @OneToOne(mappedBy = "cart")
    private Orders orders;

}
