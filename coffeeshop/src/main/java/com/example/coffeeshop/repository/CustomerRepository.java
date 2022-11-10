package com.example.coffeeshop.repository;

import com.example.coffeeshop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByEmailAddress(String email);
}
