package com.example.coffeeshop.orders;

import com.example.coffeeshop.cart.Cart;
import com.example.coffeeshop.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Orders")
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
