package api_testing.Reqres;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import api_testing.config.EnvironmentConfig;
import io.restassured.http.ContentType;

public class PutDataTest {
    @Test
    public void putUpdate(){

        baseURI = "https://reqres.in/api/";
        JSONObject jsonPutData = new JSONObject();
        jsonPutData.put("name", "Rajweer");
        jsonPutData.put("job", "Engineer");

        given()
            .header("x-api-key", EnvironmentConfig.getReqresApiKey())
            .contentType(ContentType.JSON)
            .body(jsonPutData.toJSONString())
        .when()
            .put("users/2")
        .then()
            .statusCode(200).log().all();

    }
    
}
