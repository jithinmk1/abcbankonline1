package com.example.demo;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.is;

public class accountTest {

    @Test
    void contextLoads() {
    }

    @Test
    public void testResponsecode(){
        Response response= get("http://localhost:8080/account_transactions/3333");
        int code=response.getStatusCode();
        System.out.println("statuscode is  "  +code);
        Assert.assertEquals(code,200);
    }

}
