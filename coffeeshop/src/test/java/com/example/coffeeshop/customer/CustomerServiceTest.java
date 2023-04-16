package com.example.coffeeshop.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // instead of AutoCloseable code
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @Test
    void canFindAllCustomers() {
        //when
        underTest.findAllCustomers();

        //then
        verify(customerRepository).findAll();

    }

    @Test
    void canSaveCustomer() {
        //given
        Customer vivianne = new Customer(3L, "Vivianne", "LaBone",
                "vivianne@examplu.com", "11-356-877",
                "Caramelo 3411F, 121-45 Steaqks", new ArrayList<>());

        //when
        // -> obj that service receives
        underTest.saveCustomer(vivianne);

        //then
        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);

        // -> obj that repository receives
        verify(customerRepository).save(customerArgumentCaptor.capture());
        Customer capturedCustomer = customerArgumentCaptor.getValue();

        // -> compare if obj received in service is the same obj received in repository
        assertThat(capturedCustomer).isEqualTo(vivianne);
    }

    @Test
    void willThrowWhenEmailIsTaken() {
        //given
        Customer vivianne = new Customer(3L, "Vivianne", "LaBone",
                "vivianne@examplu.com", "11-356-877",
                "Caramelo 3411F, 121-45 Steaqks", new ArrayList<>());

        //this pass but not sure if logic here is correct -> we want to get an obj
        // because our query returns customer if there is one with the same email
        given(customerRepository.findByEmailAddress(vivianne.getEmailAddress()))
                .willReturn(Optional.of(vivianne));

        //when
        //then
        assertThatThrownBy(() -> underTest.saveCustomer(vivianne))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("This email address is taken");

        verify(customerRepository, never()).save(any());
    }

    @Test
    void findCustomer() {
    }

    @Test
    void updateCustomer() {
    }

//    @Test
//    @Disabled
//    void deleteCustomer() {
//        //given
//        Customer vivianne = new Customer(3L, "Vivianne", "LaBone",
//                "vivianne@examplu.com", "11-356-877",
//                "Caramelo 3411F, 121-45 Steaqks", new ArrayList<>());
//
//        underTest.saveCustomer(vivianne);
//
//        //when
//        when(customerRepository.findById(vivianne.getId())).thenReturn(Optional.of(vivianne));
//
//        //then
//        underTest.deleteCustomer(vivianne.getId());
//        verify(customerRepository).deleteById(vivianne.getId());
//    }
}