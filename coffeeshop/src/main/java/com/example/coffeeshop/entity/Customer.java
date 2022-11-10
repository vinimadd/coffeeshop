package com.example.coffeeshop.entity;

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
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @NotEmpty(message = "First name field can not be empty")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Last name field can not be empty")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "Address field can not be empty")
    @Column(name = "address")
    private String address;

    @NotEmpty(message = "City field can not be empty")
    @Column(name = "city")
    private String city;

    @Email(message = "Email must be valid")
    @Column(name = "email")
    private String emailAddress;

    @NotEmpty(message = "Phone field can not be empty")
    @Column(name = "phone")
    private String phoneNumber;

//    @OneToMany
//    @JoinTable(
//            name = "customer_order_rel",
//            joinColumns = @JoinColumn(name = "customer_id"),
//            inverseJoinColumns = @JoinColumn(name = "customer_order_id"))
//    List<Order> orders;
}
