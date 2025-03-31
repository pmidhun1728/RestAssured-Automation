package org.org.commons;

import utils.commonutils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class BaseGoogle {

    public static RequestSpecification spec;
    public static RequestSpecification librarySpec;


    public BaseGoogle() {

        RestAssured.baseURI = ConfigReader.getProperty("google_url");
        RestAssured.baseURI = ConfigReader.getProperty("library_baseurl");
        spec = given()
                .log().everything()
                .header("Content-Type", "application/json");

        librarySpec= given()
                .log().everything()
                .header("Content-Type", "application/json");

    }
    public Response postRequest(Object body, String endPoint){
        return spec.body(body).post(endPoint);
    }

    public Response getRequest(String endPoint, String placeId){
        return spec
                .log().everything()
                .queryParam("place_id", placeId)
                .queryParam("key", "qaclick123")
                .get(endPoint);
    }

    public Response putRequest(Object body, String endPoint){
        return spec.log().everything()
                .queryParam("key", "qaclick123")
                .body(body)
                .put(endPoint);
    }

    public Response deleteRequest(Object body, String endPoint){
        return spec.log().everything()
                .queryParam("key", "qaclick123")
                .body(body)
                .delete(endPoint);
    }

    public Response postLibraryRequest(Object body, String endPoint){
        return librarySpec.body(body).post(endPoint);
    }

    public Response getLibrary(String value, String endPoint){
        return spec
                .queryParam("ID", value)
                .get(endPoint);
    }

    public Response deleteLibrary(Object body, String endPoint){

        return spec
                .body(body)
                .delete(endPoint);
    }
}
