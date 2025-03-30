package org.org.tests;

import com.org.utils.Location;
import com.org.utils.LocationData;
import io.restassured.response.Response;
import org.org.commons.BaseGoogle;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class GoogleTest extends BaseGoogle {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void postCall(){

        Location location = new Location(-38.383494,33.427362);
        LocationData locationData = new LocationData(location, 50,
                "Frontline house",
                "(+91) 983 893 3937",
                "29, side layout, cohen 09",
                Arrays.asList("shoe park", "shop"),
                "http://google.com",
                "French-IN"
         );
        Response response = postRequest(locationData, "/maps/api/place/add/json?key=qaclick123");

//        response.getBody().prettyPrint();
        int getStatus = response.getStatusCode();

        String getPlaceId = response.jsonPath().getString("place_id");
        System.out.println(getPlaceId);


        Response getResponse = given()
                .queryParam("place_id", getPlaceId)
                .queryParam("key", "qaclick123")
                        .when()
                                .get("https://rahulshettyacademy.com/maps/api/place/add/json")
                                        .then()
                                                .log().everything()
                        .extract().response();


        getResponse.getBody().prettyPrint();


    }
}
