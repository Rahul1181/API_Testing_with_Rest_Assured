package api_testing.localServerSetup;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class httpMethodAction {

    @BeforeClass
    public void setup() {
        baseURI = "http://localhost:3000/";
    }

    @Test
    public void getUserData() {
        when()
            .get("users")
        .then()
            .statusCode(200).log().body();
    }

    @Test
    public void postUserData() {
        JSONObject addUserData = new JSONObject();
        addUserData.put("id", 5);
        addUserData.put("firstname", "Jadish");
        addUserData.put("lastname", "Shah");
        addUserData.put("Address", "Chennai");
        addUserData.put("job", "Home Designer");

        given()
            .contentType(ContentType.JSON)
            .body(addUserData.toJSONString())
        .when()
            .post("users")
        .then()
            .statusCode(201).log().body();

    }

    @Test
    public void putProfileData() {
        JSONObject updateProfile = new JSONObject();
        updateProfile.put("name", "My Server");
        updateProfile.put("country", "India");

        given()
            .contentType(ContentType.JSON)
            .body(updateProfile.toJSONString())
        .when()
            .put("profile")
        .then()
            .statusCode(200).log().body();

    }

    @Test
    public void patchComments() {
        JSONObject patchComments = new JSONObject();
        patchComments.put("body", "Welcome to the new Server");
        patchComments.put("postId", "ab7589");
        patchComments.put("postCode", 826475);

        given()
            .contentType(ContentType.JSON)
            .body(patchComments.toJSONString())
        .when()
            .patch("comments/1")
        .then()
            .statusCode(200).log().body();

    }

    @Test
    public void deleteUserData() {

        //When you delete from JSON server you will get status code 200 Ok
        when()
            .delete("users/4")
        .then()
            .statusCode(200).log().body();

    }

}
