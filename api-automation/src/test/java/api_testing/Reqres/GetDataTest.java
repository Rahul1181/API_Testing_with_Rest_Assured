package api_testing.Reqres;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasItems;

import org.testng.Assert;
import org.testng.annotations.Test;

import api_testing.config.EnvironmentConfig;
import io.restassured.response.Response;

public class GetDataTest {
    @Test
    //Method name is based on the endpoint result
    public void getListOfUsers() {
        // 2 ways to Stores the response
        // Response usersList = RestAssured.get("https://reqres.in/api/users?page=2");

        // Fluent way to Stores the response
        Response usersList = (Response) given()
                .header("x-api-key", EnvironmentConfig.getReqresApiKey())
                .when().get("https://reqres.in/api/users?page=2");

        System.out.println("Status code is :" + usersList.getStatusCode());
        System.out.println("Time taken to find the data: " + usersList.getTime());
        System.out.println("Response body is :" + usersList.getBody().asString());
        System.out.println("Header Details : " + usersList.getHeader("content-type"));

        given()
            .header("x-api-key", EnvironmentConfig.getReqresApiKey())
            .get("https://reqres.in/api/users?page=2")
        .then()
            .body("data.last_name", hasItems("Ferguson", "Edwards"));

        int statusCode = usersList.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }
    @Test
    public void getSingleUser(){
        //To stop redundent website link
        baseURI = "https://reqres.in/api/";

        //Validates the status code
        given().header("x-api-key", EnvironmentConfig.getReqresApiKey()).get("users/2")
        .then().statusCode(200);

        //Validate the first_name of the user and getting all the logs
        given().header("x-api-key", EnvironmentConfig.getReqresApiKey()).get("users/2")
        .then().body("data.first_name", equalTo("Janet")).log().all();

    }
    @Test
    public void getListResources(){
        baseURI = "https://reqres.in/api/";
        given()
            .header("x-api-key", EnvironmentConfig.getReqresApiKey()).get("unknown")
        .then()
            .body("data[0].name", equalTo("cerulean"));
            
    }

}
