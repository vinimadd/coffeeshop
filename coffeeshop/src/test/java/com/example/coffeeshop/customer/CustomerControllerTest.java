package com.example.coffeeshop.customer;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CustomerControllerTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    private static final String requestBody = """
            {
             "firstName": "Vivianne",
              "lastname": "LaBone",
              "emailAddress": "vivianne@examplu.com",
              "phoneNumber": "11-356-877",
              "address": "Caramelo 3411F, 121-45 Steaqks"\s
            }""";

    @Test
    void canFindAllCustomersRequest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/v1/customers")
                .then()
                .extract().response();

        assertEquals(200, response.statusCode());
    }

    @Test
    void canSaveCustomerRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .contentType(ContentType.JSON)
                .and()
                .body(requestBody)
                .when()
                .post("/api/v1/customers")
                .then()
                .extract().response();

        assertEquals(200, response.statusCode());
        assertEquals("vivianne@examplu.com", response.jsonPath().getString("[2].emailAddress"));
    }

    @Test
    void canFindCustomerRequest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param(("customerId"),"1")
                .when()
                .get("/api/v1/customers")
                .then()
                .extract().response();

        assertEquals(200, response.statusCode());
        assertEquals("mizuki@examplu.com", response.jsonPath().getString("[0].emailAddress"));
    }

    @Test
    void canDeleteCustomerRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/api/v1/customers/1")
                .then()
                .extract().response();

        assertEquals(200, response.statusCode());
    }

    @Test
    void updateCustomer() {
        Response response = given()
                .header("Content-type", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .put("/api/v1/customers/1?email=vivi@examplu.com")
                .then()
                .extract().response();

        assertEquals(200, response.statusCode());
        assertEquals("vivi@examplu.com", response.jsonPath().getString("[0].emailAddress"));

    }
}