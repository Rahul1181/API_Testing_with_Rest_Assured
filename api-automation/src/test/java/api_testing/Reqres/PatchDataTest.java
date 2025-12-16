package api_testing.Reqres;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import api_testing.config.EnvironmentConfig;
import io.restassured.http.ContentType;

public class PatchDataTest {
    @Test
    public void updateData(){
        baseURI = "https://reqres.in/api/";

        JSONObject jsonPatchData = new JSONObject();
        jsonPatchData.put("name", "Mixer Grinder");
        jsonPatchData.put("job", "Grinding");
        
        given()
            .header("x-api-key", EnvironmentConfig.getReqresApiKey())
            .contentType(ContentType.JSON)
            .body(jsonPatchData.toJSONString())
        .when()
            .patch("users/2")
        .then()
            .statusCode(200).log().all();
    }
}
