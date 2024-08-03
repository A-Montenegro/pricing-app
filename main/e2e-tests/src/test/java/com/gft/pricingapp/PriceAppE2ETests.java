package com.gft.pricingapp;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceAppE2ETests {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void testGetExistingPrice() {
        Response response = RestAssured.given()
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .queryParam("applicationDate", "2020-06-14T10:00:00")
                .when()
                .get("/price")
                .then()
                .statusCode(200)
                .body("price", equalTo(35.50f))
                .extract()
                .response();
    }

    @Test
    public void testGetNotExistingPrice() {
        Response response = RestAssured.given()
                .queryParam("productId", 77524)
                .queryParam("brandId", 1)
                .queryParam("applicationDate", "2020-06-14T16:00:00")
                .when()
                .get("/price")
                .then()
                .statusCode(404)
                .body("message", equalTo("Price not found for the given criteria"))
                .extract()
                .response();
    }

    @Test
    public void testGetPriceBadRequestWrongProduct() {
        Response response = RestAssured.given()
                .queryParam("productId", -35455)
                .queryParam("brandId", 1)
                .queryParam("applicationDate", "2020-06-14T21:00:00")
                .when()
                .get("/price")
                .then()
                .statusCode(400)
                .body("productId", equalTo("Product ID must be positive"))
                .extract()
                .response();
    }

    @Test
    public void testGetPriceBadRequestWrongBrand() {
        Response response = RestAssured.given()
                .queryParam("productId", 35455)
                .queryParam("applicationDate", "2020-06-14T21:00:00")
                .when()
                .get("/price")
                .then()
                .statusCode(400)
                .body("brandId", equalTo("Brand ID must not be null"))
                .extract()
                .response();
    }

    @Test
    public void testGetPriceBadRequestWrongApplicationDate() {
        Response response = RestAssured.given()
                .queryParam("productId", 35455)
                .queryParam("applicationDate", "20-06-14T21:00:00")
                .when()
                .get("/price")
                .then()
                .statusCode(400)
                .body("applicationDate", startsWith("Failed to convert"))
                .extract()
                .response();
    }
}
