package api_testing.Reqres;

import org.testng.annotations.Test;
import api_testing.config.EnvironmentConfig;
import static io.restassured.RestAssured.given;;

public class DeleteDataTest {
    @Test
    public void deleteUserData(){

        given()
            .header("x-api-key", EnvironmentConfig.getReqresApiKey())
        .when()
            .delete(EnvironmentConfig.getBaseUri() + "users/2")
        .then()
            .statusCode(204).log().all();

    }
    
}
