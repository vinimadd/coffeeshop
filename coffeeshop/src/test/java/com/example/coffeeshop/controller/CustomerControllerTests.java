package com.example.coffeeshop.controller;

import com.example.coffeeshop.entity.Customer;
import com.example.coffeeshop.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTests {


    private static MockHttpServletRequest request;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    CustomerService customerServiceMock;

    @Autowired
    private ObjectMapper objectMapper;

    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//    private Customer customer;

    public static final MediaType APPLICATION_JSON_UTF8 = MediaType.APPLICATION_JSON;


    @BeforeAll
    public static void setup() {
        request = new MockHttpServletRequest();

        request.setParameter("firstname", "Saito");
        request.setParameter("lastname", "Yumesaki");
        request.setParameter("email", "saito_numee@samplu.com");
        request.setParameter("address", "Yenar 789");
        request.setParameter("city", "Derko");
        request.setParameter("phone", "234564323");

    }

    @Test
    public void createCustomerHttpRequest() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("Saito");
        customer.setLastName("Yumesaki");
        customer.setEmailAddress("saito_numee@samplu.com");
        customer.setAddress("Yenar 789");
        customer.setCity("Derko");
        customer.setPhoneNumber("234564323");



        mockMvc.perform(MockMvcRequestBuilders.post("/api/form")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$", hasSize(2)));

        Customer verifyCustomer = customerServiceMock.findByEmailAddress("saito_numee@samplu.com");
        assertNotNull(verifyCustomer, "Customer should be valid.");
    }
}
