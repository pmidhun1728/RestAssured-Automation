package org.org.commons;

import com.org.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseGoogle {

    public static RequestSpecification spec;
    public static RequestSpecification getSpec;

    public BaseGoogle() {

//        File file = new File("src/test/resources/request.txt");

        RestAssured.baseURI = ConfigReader.getProperty("google_url");
        spec = given()
                .log().everything()
                .header("Content-Type", "application/json");
//                .multiPart("file", file);


//        getSpec = given()
//                .log().everything()
//                .queryParam("place_id", "3a69867372147a81508edbfcdef84b80")
//                .queryParam("key", "qaclick123");


    }
    public Response postRequest(Object body, String endPoint){
        return spec.body(body).post(endPoint);
    }

//    public Response getRequest(String endPoint){
//        return getSpec.get(endPoint);
//    }

}
