package com.example.coffeeshop.repository;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class Order {

    @NotBlank(message = "is required")
    private String firstName;

    @NotBlank(message = "is required")
    private String lastName;

    @Email
    private String emailAddress;

    @NotBlank(message = "is required")
    private String phoneNumber;

    @NotBlank(message = "is required")
    private String street;

    @NotBlank(message = "is required")
    private String city;

    @NotBlank(message = "is required")
    private String postalCode;

}
