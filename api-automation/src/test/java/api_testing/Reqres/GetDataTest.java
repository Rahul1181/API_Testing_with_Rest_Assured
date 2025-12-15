package api_testing.Reqres;

import org.testng.Assert;
import org.testng.annotations.Test;

import api_testing.config.EnvironmentConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetDataTest {
    @Test
    public void userData() {
        // 2 ways to Stores the response
        // Response userInfo = RestAssured.get("https://reqres.in/api/users?page=2");

        // Fluent way to Stores the response
        Response userInfo = (Response) given()
                .header("x-api-key", EnvironmentConfig.getReqresApiKey())
                .when().get("https://reqres.in/api/users?page=2");

        System.out.println("Status code is :" + userInfo.getStatusCode());
        System.out.println("Time taken to find the data: " + userInfo.getTime());
        System.out.println("Response body is :" + userInfo.getBody().asString());
        System.out.println("Header Details : " + userInfo.getHeader("content-type"));

        int statusCode = userInfo.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }

}
