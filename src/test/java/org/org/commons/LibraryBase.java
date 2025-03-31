package org.org.commons;

import utils.commonutils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class LibraryBase {
    public static RequestSpecification spec;

    public LibraryBase() {

        RestAssured.baseURI = ConfigReader.getProperty("library_baseurl");

        spec = given()
                .header("Content-Type", "application/json");

    }


    public Response postRequest(Object body, String endPoint){
        return spec.body(body).post();
    }
}
