package com.example.demo;
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

public class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testCustomerList() {

        get("http://localhost:8080/users")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(6));


        get("http://localhost:8080/users/1")
                .then()
                .assertThat()
                .statusCode(200)
                .body("user_id", Matchers.equalTo(1));

        get("http://localhost:8080/users/1")
                .then()
                .assertThat()
                .statusCode(200)
                .body("first_name", Matchers.equalTo("bhaaavana"));



    }
    @Test
    public void loanList(){
        get("http://localhost:8080/loans")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(4));


        get("http://localhost:8080/loans/11111")
                .then()
                .assertThat()
                .statusCode(200)
                .body("loan_id", Matchers.equalTo(11111));

        get("http://localhost:8080/loans/11111")
                .then()
                .assertThat()
                .statusCode(200)
                .body("loan_type", Matchers.equalTo("auto"));



    }
    @Test
    public void loanStatus(){
        get("http://localhost:8080/loans")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(4));


        get("http://localhost:8080/loans/11111")
                .then()
                .assertThat()
                .statusCode(200)
                .body("loan_id", Matchers.equalTo(11111));

        get("http://localhost:8080/loans/11111")
                .then()
                .assertThat()
                .statusCode(200)
                .body("loan_status", Matchers.equalTo("active"));


    }
    @Test
    public void billPayee(){
        get("http://localhost:8080/bill_payees")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(2));


        get("http://localhost:8080/bill_payees/444")
                .then()
                .assertThat()
                .statusCode(200)
                .body("payee_id", Matchers.equalTo(444));

        get("http://localhost:8080/bill_payees/444")
                .then()
                .assertThat()
                .statusCode(200)
                .body("payee_phone", Matchers.equalTo("1234566789"));


    }
    @Test
    public void accountTransaction(){
        get("http://localhost:8080/account_transactions")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(3));


        get("http://localhost:8080/account_transactions/1111")
                .then()
                .assertThat()
                .statusCode(200)
                .body("account_id", Matchers.equalTo(1111));

        get("http://localhost:8080/account_transactions/1111")
                .then()
                .assertThat()
                .statusCode(200)
                .body("transaction_no", Matchers.equalTo("22"));


    }
    @Test
    public void accountList(){
        get("http://localhost:8080/accounts")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(8));


        get("http://localhost:8080/accounts/1111")
                .then()
                .assertThat()
                .statusCode(200)
                .body("account_id", Matchers.equalTo(1111));

        get("http://localhost:8080/accounts/1111")
                .then()
                .assertThat()
                .statusCode(200)
                .body("email_id", Matchers.equalTo("bhuvi@gmail.com"));

    }
    @Test
    public void getAccounttransaction(){
        get("http://localhost:8080/account_transactions")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(3));


        get("http://localhost:8080/account_transactions/3333")
                .then()
                .assertThat()
                .statusCode(200)
                .body("account_id", Matchers.equalTo(3333));

        get("http://localhost:8080/account_transactions/3333")
                .then()
                .assertThat()
                .statusCode(200)
                .body("loan_id", Matchers.equalTo(33333));

    }
    @Test
    public void testResponsecode(){
        Response response= get("http://localhost:8080/account_transactions/3333");
        int code=response.getStatusCode();
        System.out.println("statuscode is  "  +code);
        Assert.assertEquals(code,200);
    }
    @Test
    public void checkHeader(){
        get("http://localhost:8080/users")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(6));


        get("http://localhost:8080/users/2")
                .then()
                .assertThat().log().all()
                .statusCode(200)
                .body("user_id", Matchers.equalTo(2))
                .and()
                .contentType(ContentType.JSON).and()
                .header("Connection","keep-alive");

    }
    @Test
    public void checkFloatvalue(){
        get("http://localhost:8080/account_transactions")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(3));


        get("http://localhost:8080/account_transactions/1111")
                .then()
                .assertThat()
                .statusCode(200)
                .body("account_id", Matchers.equalTo(1111));

        get("http://localhost:8080/account_transactions/1111")
                .then()
                .assertThat()
                .statusCode(200)
                .body("transaction_amount", Matchers.equalTo(600000f
                ));

    }
    @Test
    public void putchecking(){
        String Resp=given().
                header("Content-Type","application/JSON; charset=utf-8").
                body("{\"user_id\":2,\"first_name\":\"siivaraja\",\"middle_name\":\"raja\"," +
                        "\"last_name\":\"velusamy\",\"email\":\"siva@gmail.com\"," +
                        "\"mobile_number\":\"1234567980\",\"address\":\"rajaaddress\",\"password\":\"abc\"}").
                when().
                put("http://localhost:8080/users/2").
                then().assertThat().
                statusCode(200).
                extract().
                response().asString();
    }
    @Test
    public void postChecking(){
        String Resp=given().
                header("Content-Type","application/JSON; charset=utf-8").
                body("{\"account_id\":5555,\"account_name\":\"bhavana\"," +
                        "\"account_type\":\"saving\",\"account_address\":\"bhuvi address\"," +
                        "\"account_status\":\"active\",\"email_id\":\"bhavi@gmail.com\"," +
                        "\"mobile_number\":\"1234567890\",\"date_open\":\"2008-11-20 00:00:00\"," +
                        "\"date_closed\":\"2021-11-20 00:00:00\",\"account_balance\":10000.0}").
                when().
                post("http://localhost:8080/accounts").
                then().assertThat().
                statusCode(200).
                extract().
                response().asString();

    }
    @Test
    public void deleteChecking(){
        String Resp=given().
                header("Content-Type","application/JSON; charset=utf-8").
                body("{\"account_id\":5555,\"account_name\":\"bhavana\"," +
                        "\"account_type\":\"saving\",\"account_address\":\"bhuvi address\"," +
                        "\"account_status\":\"active\",\"email_id\":\"bhavi@gmail.com\"," +
                        "\"mobile_number\":\"1234567890\",\"date_open\":\"2008-11-20 00:00:00\"," +
                        "\"date_closed\":\"2021-11-20 00:00:00\",\"account_balance\":10000.0}").
                when().
                delete("http://localhost:8080/accounts/5555").
                then().assertThat().
                statusCode(200).
                extract().
                response().asString();

    }
    @Test
    public void putAccounttransaction(){
        String Resp=given().
                header("Content-Type","application/JSON; charset=utf-8").
                body("{\"account_id\":1111,\"transaction_no\":\"22\"," +
                        "\"transaction_date\":\"2019-07-23 00:00:00\"," +
                        "\"transaction_amount\":600000.0,\"transaction_type\":\"cash\"," +
                        "\"loan_id\":11111,\"payee_id\":222}").
                when().
                put("http://localhost:8080/account_transactions/1111").
                then().assertThat().
                statusCode(200).
                extract().
                response().asString();

    }


}