package org.org.tests;

import com.org.utils.CreateData;
import com.org.utils.LoginData;
import com.org.utils.PostManData;
import io.restassured.response.Response;
import org.org.commons.Base;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
}
