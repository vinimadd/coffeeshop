package com.example.coffeeshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

   @Column(name = "customer_id")
    private int customerId;

   @Column(name = "product_id")
    private int productId;

   @Column(name = "quantity")
    private int quantity;

   @Column(name = "create_date")
    private Date createDate;

   @ManyToOne
   @JoinColumn(name = "product_id", insertable = false, updatable = false)
   private Product product;

}
