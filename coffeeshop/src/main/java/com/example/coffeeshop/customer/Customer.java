package com.example.coffeeshop.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class Customer {

//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String emailAddress;

    private String phoneNumber;

//    @OneToMany(cascade = {CascadeType.ALL})
//    private List<Order> orders;

}
