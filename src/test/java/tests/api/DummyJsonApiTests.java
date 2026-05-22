package tests.api;

//Conține clasa `DummyJsonApiTests` reprezentând suita de teste pentru backend.//


import data.TestData;
import models.UserApi;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import utils.TestConfig;
import utils.TestListener;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Listeners(TestListener.class)
public class DummyJsonApiTests {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = TestConfig.API_BASE_URL;
    }

    @Test(priority = 1)
    public void getValidUser_Returns200() {
        given()
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("firstName", notNullValue());
    }

    @Test(priority = 2)
    public void createUser_Returns201() {
        UserApi user = UserApi.builder()
                .firstName("Ionut")
                .lastName("User")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/users/add")
                .then()
                .statusCode(201)
                .body("firstName", equalTo(TestData.API_USER_FIRST_NAME))
                .body("id", notNullValue());
    }

    @Test(priority = 3)
    public void updateUser_Returns200() {

        UserApi user = UserApi.builder()
                .firstName("Test")
                .lastName(TestData.API_USER_NEW_LAST_NAME)
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .put("/users/1")
                .then()
                .statusCode(200)
                .body("lastName", equalTo(TestData.API_USER_NEW_LAST_NAME));
    }

    @Test(priority = 4)
    public void deleteUser_Returns200() {
        given()
                .when()
                .delete("/users/1")
                .then()
                .statusCode(200)
                .body("isDeleted", equalTo(true));
    }

    @Test(priority = 5)
    public void getInvalidUser_Returns404() {
        given()
                .when()
                .get("/users/999")
                .then()
                .statusCode(404);
    }
}