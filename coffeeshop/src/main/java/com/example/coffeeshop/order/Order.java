package com.example.coffeeshop.order;

import com.example.coffeeshop.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {

//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private Long productId;

    private int quantity ;

    private LocalDateTime createDate;

//    @CreationTimestamp
//    @Column(updatable = false)
//    Timestamp dateCreated;

    private List<Product> products;

//   @ManyToOne
//   private Product product;

}
