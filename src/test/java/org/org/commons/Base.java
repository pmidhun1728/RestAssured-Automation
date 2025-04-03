package org.org.commons;

import utils.commonutils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Base {
    public static RequestSpecification requestSpecification;
    public static RequestSpecification requestSpecificationPostman;
    private static RequestSpecification reqResSpec;
    private static RequestSpecification goRestSpec;


    public Base() {
        RestAssured.baseURI = ConfigReader.getProperty("url");
        RestAssured.baseURI = ConfigReader.getProperty("base_url");
        RestAssured.baseURI = ConfigReader.getProperty("reqres_url");
        RestAssured.baseURI = ConfigReader.getProperty("reqres_baseurl");

        requestSpecification =  given()
                .log().all()
                .header("Cookie", "_abck=69F4BF87142971D2AF4721E2594D4B44~-1~YAAQHzMyF2a5WtmVAQAA06lw3g3XSNca9yvdfPP1VmF11sQAaOD9gOkD6H9AXxb4/wdyYQ8JOYCNu9lH9exY0rux1z5wDJ4rfji6okr+kKi1x9xOHZGRx3mF5LhCKPOlsNnqrfh6PUPpMK/9029oG1eHu/T4U+YOpCJaHl1KHPDF39/b52VHqdfkZk2zlqAdnLHy1mW+bepkxCUhGXXzhpRbhnniUc8lZVmhhtOdPw/hKOdwU7rz2TVFvbPfDTriKFLqBMW+p46ZDuBw+tEIsMuP931lFuuCLzTgabC6hsS0oDhNfcqrpbcF+L6TnUONZIrfrwPDaEQATvgYMQ9l/uCeIt0VEd4k0FTNM/PozaivvgfxW1+HiRb1IXzH7Qyktkj5YscPURJ9rjku7rMtq1iTVQgLYoBd+Zj/oyBXlYF/Xmy4euJ/rbaU~-1~-1~-1; ak_bmsc=4B16EC9D08AB0CF8FEED9D3664D0C06B~000000000000000000000000000000~YAAQHzMyF2e5WtmVAQAA06lw3hsYOdxua7g+d2oWKNNghwydGfg5l71aqcVX3T5+t2ySZdjVD3+qSknI75bTrJ8ktkk3tNkCAV1Mr6ySDr39zIuGErPyktq0B00agGACvPzNDX0aQDlovP4hyLjV66WO1cqKaMpoFUMfGHdg9FSYH0cxJJUYiavPgEptSkFROafCH2LInVn9mrIQxK5r5Niv8TF46jR7d08RfM/NcArhQnDE9Ij0BbkIwcSjpg2EsXnweCrci73+P/fXOq2W8cZlLk5p8ET21b/UTSAbuPR0a+rA6bI2k+w8vhlXZ+7DssJ4/S3V0xuR3si2cPhzDUt28gAglOEdQfA/ToGF; bm_sz=EB103C16D78DF17149B8DA6F35698E16~YAAQHzMyF2i5WtmVAQAA06lw3htkTY86LnfyiQqu57FG3JTrZao6r4Ucpjo5m2q0/dNcEGGa2Cc9Q+aMosI2q7ygv1DJFhKdr2trj1YymoYBKL1BYaj+vSDm+sPOk+aDSIu2bnQ4RlN/D+GfNFogZDniqSrHyPHG2CqUZrExbAZTvNQRGmTzLtJwqEgh+0i6vWSV4LWxvXGcVlJEybeAM87ebcdBS2rAxViOc19D6mbYVLQtcmEv1aFKLk9DPHw/s7yFae4KyqK/SK5b+7vt1sTxJCsO9QQBYPkm1e9Hbf68Ur8loCiGNq3Oy3ObTGZ9fG52ScQIt/+LzpNeqEmpaiPsZRXHmFBTqLR4+lfp0Joh~3552049~4277555\n")
                .header("x-cf-source-id", "coding-challenge")
                .header("x-cf-corr-id", "fcb24980-be6c-11eb-8529-0242ac130003")
                .header("Content-Type", "application/json");

        requestSpecificationPostman =  given()
                .log().all()
                .header("Content-Type", "application/json")
                .header("Cookie", "sails.sid=s%3AAq8L38u6JRZWkGVg9m1wNRuWfN4y7Upv.3EQ4hZBZQhve9o0nKSuiII3hVfLbFzZggs4fge1RRAg");

        reqResSpec = given()
                .log().all()
                .header("Content-Type", "application/json");

        String auth ="9cee3cf96dbafa82ff98cc1f76c3fbf650db688bb5024a446d01ed8e0ffa03d7";
        goRestSpec = given()
                .log().everything()
                .header("Authorization", auth)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "_gorest_session=r4Si7qIqN038pfH7KWXP3d3uwcghgGIbwkreRm2t0tkkmzEt9xq9hPs2Td0pU7CMM6mJCGOow2TCqtIgjMhZEqBwNiT52KsCVJQbaD%2FWpEwUaV41Ns2X08r8oFAIrVk2Mtnm9pZubA7F3VlSXiHjoop1FqMabn0fLjHQsn7eLvBIyOH9LaALIPjLXLwuRGBD2Umf26R1uWLQcBRY8pdmOtO9STz0uCpsr2PYtcyEx5wjCwaB%2B%2B0gDPo%2Ba8VpoGxKpyq96HvO4aS9ZzP8cRXNI%2BCmSKBmnpJaRg2pG1koIVtW5hMOXBtCO3z2TPTrE9QUhnIE2G5naP4p6LXA8a4DsKSonT4tdHCX%2BzVvQ2qllYLL8muINNAATbell%2BenOrqzHgQgL3Qbfb0d3I0%3D--lZn%2FP88V6meiA8mk--1h4BY8xXAZP8RNIGLk94Ig%3D%3D");

        goRestSpec = given()
                .log().everything()
                .header("Content-Type", "application/json");

    }
    public Response postRequest(Object body, String endPoint){
        return requestSpecification.body(body).post(endPoint);
    }

    public Response postManRequest(Object body, String endPoint){
        return requestSpecificationPostman.body(body).post(endPoint);
    }

    public Response getPostManRequest(String endPoint){
        return requestSpecificationPostman.get(endPoint);
    }

    public Response reqResPostRequest(Object body, String endpoint){
        return reqResSpec.body(body).post(endpoint);
    }

    public Response goRestPostRequest(Object body, String endpoint){
        return reqResSpec.body(body).post(endpoint);
    }

    public Response goRestSpecRequest(int pageNumber, String endPoint){
        return goRestSpec
                .log().everything()
                .queryParam("page", pageNumber)
                .get(endPoint);
    }
}
