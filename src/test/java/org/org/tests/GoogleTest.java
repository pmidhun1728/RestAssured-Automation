package org.org.tests;

import com.org.utils.*;
import com.org.utils.googledata.DeleteData;
import com.org.utils.googledata.Location;
import com.org.utils.googledata.LocationData;
import com.org.utils.googledata.PutData;
import io.restassured.response.Response;
import org.org.commons.BaseGoogle;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;

public class GoogleTest extends BaseGoogle {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void chainingAPICall() {

        Location location = new Location(-38.383494, 33.427362);
        LocationData locationData = new LocationData(location, 50,
                "Frontline house",
                "(+91) 983 893 3937",
                "29, side layout, cohen 09",
                Arrays.asList("shoe park", "shop"),
                "http://google.com",
                "French-IN"
        );

        //POST Call
        Response response = postRequest(locationData, "/maps/api/place/add/json?key=qaclick123");
        response.getBody().prettyPrint();
        int getStatus = response.getStatusCode();
        softAssert.assertEquals(getStatus, 200);

        String getPlaceId = response.jsonPath().getString("place_id");
        System.out.println(getPlaceId);


        //GET Call
        Response getResponse = getRequest("/maps/api/place/get/json", getPlaceId);
        System.out.println(getResponse.getBody().prettyPrint());
        String getAddress = getResponse.jsonPath().getString("address");
        System.out.println(getAddress);

        //PUT Call

        FakerClass fakerClass = new FakerClass();
        String getAddressField = FakerClass.getAddress();
        PutData putData = new PutData(getPlaceId, getAddressField, "qaclick123");
        Response putResponse = putRequest(putData,"/maps/api/place/update/json");

        putResponse.getBody().prettyPrint();

        String getMsg = putResponse.jsonPath().getString("msg");
        softAssert.assertEquals(getMsg, "Address successfully updated");

        //DELETE Call

        DeleteData deleteData= new DeleteData(getPlaceId);
        Response deleteResponse = deleteRequest(deleteData , "/maps/api/place/delete/json");
        deleteResponse.getBody().prettyPrint();

        String deleteStatus = deleteResponse.jsonPath().getString("status");
        System.out.println(deleteStatus);

        softAssert.assertEquals(deleteResponse.getStatusCode(), 200);


    }
}
