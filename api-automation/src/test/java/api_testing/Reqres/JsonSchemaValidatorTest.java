package api_testing.Reqres;

import org.testng.annotations.Test;

import api_testing.config.EnvironmentConfig;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidatorTest {
    @Test
    public void testJsonSchema(){
        given()
            .header("x-api-key", EnvironmentConfig.getReqresApiKey())
        .when()
            .get(EnvironmentConfig.getBaseUri() +"users?page=2")
        .then()
            .assertThat().body(matchesJsonSchemaInClasspath("api_testing/schemaUserData.json"))
            .statusCode(200)
            .log()
            .body();
    }
    
}
