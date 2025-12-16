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

    @Test(priority = 1)
    public void getUserData() {
        when()
            .get("users")
        .then()
            .statusCode(200).log().body();
    }

    @Test(priority = 2)
    public void postUserData() {
        JSONObject addUserData = new JSONObject();
        addUserData.put("id", 4);
        addUserData.put("firstname", "Monnu");
        addUserData.put("lastname", "Shah");
        addUserData.put("Address", "Delhi");
        addUserData.put("job", "Dressing Designer");

        given()
            .contentType(ContentType.JSON)
            .body(addUserData.toJSONString())
        .when()
            .post("users")
        .then()
            .statusCode(201).log().body();

    }

    @Test(priority = 3)
    public void putProfileData() {
        JSONObject updateProfile = new JSONObject();
        updateProfile.put("name", "Pune Service Cost Center");
        updateProfile.put("country", "USA");

        given()
            .contentType(ContentType.JSON)
            .body(updateProfile.toJSONString())
        .when()
            .put("profile")
        .then()
            .statusCode(200).log().body();

    }

    @Test(priority = 4)
    public void patchComments() {
        JSONObject patchComments = new JSONObject();
        patchComments.put("body", "Welcome to our Pune Cost Service center");
        patchComments.put("postId", "ab1580");
        patchComments.put("postCode", 826791);

        given()
            .contentType(ContentType.JSON)
            .body(patchComments.toJSONString())
        .when()
            .patch("comments/1")
        .then()
            .statusCode(200).log().body();

    }

    @Test(priority = 5)
    public void deleteUserData() {

        //When you delete from JSON server you will get status code 200 Ok
        when()
            .delete("users/4")
        .then()
            .statusCode(200).log().body();

    }

}
