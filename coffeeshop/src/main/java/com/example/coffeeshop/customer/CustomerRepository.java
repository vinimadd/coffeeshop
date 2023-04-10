package com.example.coffeeshop.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    @Query(value = "SELECT email FROM customer WHERE email = :email ", nativeQuery = true)
//    public Customer findByEmailAddress(@Param("email") String email);

}
