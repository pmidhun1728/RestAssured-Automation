package org.org.tests;

import groovy.util.logging.Log4j;
import io.restassured.response.Response;
import org.org.commons.BaseGoogle;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.commonutils.FakerClass;
import utils.googleutils.LibraryData;

import java.util.HashMap;
import java.util.Map;

public class LibraryTest extends BaseGoogle {
    private static Log4j log;

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void postLibraryCall(){

        LibraryData libraryData= new LibraryData(FakerClass.getName(), FakerClass.getName(), FakerClass.getId(), FakerClass.getName());

        //POST CALL
        Response response = postLibraryRequest(libraryData, "/Library/Addbook.php");
        response.getBody().prettyPrint();

        String getMSG = response.jsonPath().getString("Msg");
        String getID = response.jsonPath().getString("ID");
        System.out.println(getMSG);

        softAssert.assertEquals(getMSG, "successfully added");
        softAssert.assertEquals(response.getStatusCode(), 200);

        //Get Call
        Response getResponse = getLibrary(getID, "/Library/GetBook.php");
        getResponse.getBody().prettyPrint();


        //Delete Call
        Map<String, String> map = new HashMap<>();
        map.put("ID", getID);
        Response deleteResponse = deleteLibrary(map, "/Library/DeleteBook.php");
        deleteResponse.getBody().prettyPrint();

        String deletemsg = deleteResponse.jsonPath().getString("msg");
        softAssert.assertEquals(deletemsg, "book is successfully deleted");

    }
}
