package org.org.tests;

import org.testng.Assert;
import utils.commonutils.*;
import io.restassured.response.Response;
import org.org.commons.Base;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;
import java.util.Random;


public class APITest extends Base {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void postCall(){
        CreateData createData = new CreateData("b8096ec7-2150-405f-84f5-ae99864b3e96", true);
        Response response =  postRequest(createData, "");

        String json = response.getBody().prettyPrint();
        String loanAppId = response.jsonPath().getString("loanAppResumptionInfo.loanAppId");
        System.out.println(json);

        softAssert.assertEquals(loanAppId, "112814558");

    }

    @Test
    public void PostManCall(){
        PostManData postManData = new PostManData( "Sapiens", "Yuval Noah Harari", 2011);
        Response response = postManRequest(postManData, "/post");
        String title = response.jsonPath().getString("data.title");
        System.out.println("Title: " + title);
    }

    @Test
    public void GetPostManCall(){
        Response response = getPostManRequest("get");

        response.getBody().prettyPrint();
        String getHost = response.jsonPath().getString("headers.host");
        String getUrl = response.jsonPath().getString("url");

        System.out.println("host: "+ getHost);
        System.out.println("URL: "+ getUrl);

        softAssert.assertEquals(getHost, "postman-echo.com");
    }

    @Test
    public void reqResPostCall(){
        LoginData loginData = new LoginData("eve.holt@reqres.in", "cityslicka");
        Response response = reqResPostRequest(loginData, "");
        response.getBody().prettyPrint();
        String token = response.jsonPath().getString("token");
        System.out.println("Token ID is: " +token);
        softAssert.assertEquals(token, "QpwL5tke4Pnpja7X4");
    }

    @Test
    public void goRestPostCall(){
        UserCreation userCreation = new UserCreation(FakerClass.getId(), FakerClass.getName(), FakerClass.getEmail(), "Male", "Active" );

        Response response = goRestPostRequest(userCreation, "/public/v2/users");
        response.jsonPath().prettyPrint();

        softAssert.assertEquals(response.getStatusCode(), 201);
        String getGender = response.jsonPath().getString("gender");
        System.out.println(getGender);

    }
    @Test
    public void goRestSpecRequest(){

        int random = new Random().nextInt(5)+1;
        Response response = goRestSpecRequest(random, "/users");
        response.getBody().prettyPrint();

        List<Map<String, Object>> users = response.jsonPath().getList("data");

        Boolean found = false;
        for(Map<String, Object> user: users){
            if(user.get("id").equals(7)){
                Object getId = user.get("id");
                System.out.println("ID: "+getId);
                found =true;
                Assert.assertEquals(getId, 7);
                break;
            }
        }

        if(!found){
            System.out.println("There is no users that are matching with the Page Number:"+random);
        }
    }
}
