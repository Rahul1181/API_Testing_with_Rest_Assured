package api_testing.Reqres;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import api_testing.config.EnvironmentConfig;
import io.restassured.http.ContentType;

public class PostDataTest {
    @Test
    public void postCreate(){
        //Map<String, Object> newUserData = new HashMap<String, Object>();
        // newUserData.put("name", "Rahul");
        // newUserData.put("job", "private employee");

        baseURI ="https://reqres.in/api/";

        //JSON format
        JSONObject jsonFormat = new JSONObject();
        jsonFormat.put("name", "Rahul");
        jsonFormat.put("job", "private employee");
        System.out.println(jsonFormat);

        given()
            .header("x-api-key", EnvironmentConfig.getReqresApiKey())
            .header("Content-Type", "application/json")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(jsonFormat.toJSONString())
        .when()
            .post("users")
        .then()
            .statusCode(201).log().all();




    }

}
