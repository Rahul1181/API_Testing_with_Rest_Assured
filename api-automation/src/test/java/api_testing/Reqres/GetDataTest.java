package api_testing.Reqres;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetDataTest {
    @Test
    public void userData() {
        // Stores the response
        // Response bookingID = RestAssured.get("https://restful-booker.herokuapp.com/booking?firstname=Mary&lastname=Jackson");
        
        // System.out.println("Status code is :" + bookingID.getStatusCode());
        
        // System.out.println("Time taken to find the data: " + bookingID.getTime());
        
        // System.out.println("Response body is :" + bookingID.getBody().asString());
    
        // System.out.println("Header Details : " + bookingID.getHeader("content-type"));

        // int statusCode = bookingID.getStatusCode();
        // Assert.assertEquals(statusCode, 200);

    }

}
