package com.feeko256.wallet.service.baseApi;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class BaseApi {
    protected static Response GET(RequestSpecification specification, String endpoint) {
        return given().
                spec(specification).
                when().
                request(Method.GET, endpoint).
                then().log().all().extract().response();
    }

    protected static Response GET(RequestSpecification specification, String endpoint, String path, Object param) {
        return given().
                spec(specification).
                pathParam(path, param).
                when().
                request(Method.GET, endpoint).
                then().log().all().extract().response();
    }

    protected static Response POST(RequestSpecification specification, String endpoint, Object body) {
        return given().
                spec(specification).
                body(body).
                when().
                request(Method.POST, endpoint).
                then().log().all().extract().response();
    }
}
