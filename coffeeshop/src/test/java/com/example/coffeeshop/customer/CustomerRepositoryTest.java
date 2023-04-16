package com.example.coffeeshop.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository underTest;

    @Test
    void shouldFindCustomerByEmailAddress() {
        //given
        Customer vivianne = new Customer(3L, "Vivianne", "LaBone",
                "vivianne@examplu.com", "11-356-877",
                "Caramelo 3411F, 121-45 Steaqks", new ArrayList<>());

        underTest.save(vivianne);

        //when
        Customer expected = underTest.findByEmailAddress("vivianne@examplu.com").get();

        //then
        assertThat(expected).isNotNull();
        assertThat(expected).isInstanceOf(Customer.class);
    }

    @Test
    void shouldNotFindCustomerByEmailAddress() {
        //given
        String email = "vivianne@examplu.com";

        //when
        Customer expected = underTest.findByEmailAddress(email).get();

        //then
        assertThat(expected).isNull();
    }
}

