package Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTests {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGetPosts() {
        given()
        .when()
            .get("/posts")
        .then()
            .statusCode(200)
            .body("size()", equalTo(100))
            .body("userId[0]", notNullValue())
            .body("title[0]", notNullValue());
    }

    @Test
    public void testGetUserById() {
        given()
        .when()
            .get("/users/1")
        .then()
            .statusCode(200)
            .body("email", matchesRegex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            .body("address.street", notNullValue())
            .body("address.city", notNullValue())
            .body("address.geo.lat", notNullValue());
    }

    @Test
    public void testCreatePost() {
        String payload = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";

        given()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("/posts")
        .then()
            .statusCode(201)
            .body("title", equalTo("foo"))
            .body("body", equalTo("bar"))
            .body("userId", equalTo(1))
            .body("id", notNullValue());
    }

    @Test
    public void testPutAndPatchPost() {
        String putPayload = "{ \"id\": 1, \"title\": \"updated title\", \"body\": \"updated body\", \"userId\": 1 }";

        given()
            .contentType(ContentType.JSON)
            .body(putPayload)
        .when()
            .put("/posts/1")
        .then()
            .statusCode(200)
            .body("title", equalTo("updated title"))
            .body("body", equalTo("updated body"));

        String patchPayload = "{ \"title\": \"patched title\" }";

        given()
            .contentType(ContentType.JSON)
            .body(patchPayload)
        .when()
            .patch("/posts/1")
        .then()
            .statusCode(200)
            .body("title", equalTo("patched title"));
    }

    @Test
    public void testDeletePost() {
        given()
        .when()
            .delete("/posts/1")
        .then()
            .statusCode(anyOf(equalTo(200), equalTo(204)));
    }

    @Test
    public void testInvalidId() {
        given()
        .when()
            .get("/posts/99999")
        .then()
            .statusCode(anyOf(equalTo(404), equalTo(200)))
            .body(anything());
    }

    @Test
    public void testPostWithMissingFields() {
        String payload = "{ \"title\": \"only title\" }";

        given()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("/posts")
        .then()
            .statusCode(anyOf(equalTo(201), greaterThanOrEqualTo(400)));
    }

    @Test
    public void testWrongHeaders() {
        given()
            .header("Content-Type", "text/plain")
            .body("title=foo&body=bar")
        .when()
            .post("/posts")
        .then()
            .statusCode(anyOf(equalTo(400), equalTo(415), equalTo(201), equalTo(200)));
    }
}
