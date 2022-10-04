package com.example.coffeeshop.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Customer {


    private String firstName;

    private String lastName;

    private String emailAddress;

    private String phoneNumber;

    private String street;

    private String city;

    private String postalCode;

}
