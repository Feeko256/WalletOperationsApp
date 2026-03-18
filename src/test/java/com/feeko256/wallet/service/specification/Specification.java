package com.feeko256.wallet.service.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specification {
    private static RequestSpecification specification;

    public static RequestSpecification getSpecification(String host, String path) {
        if (specification == null) {
            specification = new RequestSpecBuilder()
                    .setBaseUri(host)
                    .setBasePath(path)
                    .setContentType(ContentType.JSON)
                    .build();
        }
        return specification;
    }
}
