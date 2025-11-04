package api.endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Map;
import api.utilities.ConfigReader;  // ✅ Import your config reader

public class UserEndPoints {

    static String baseUrl = ConfigReader.getProperty("base_url");
    static String apiKey  = ConfigReader.getProperty("api_key");

    public static Response getUserList() {
        return given()
                .baseUri(baseUrl)
                .header("x-api-key", apiKey)  // optional if your API needs it
                .when()
                .get("/users?page=2");
    }
    public static Response createUser(Map<String, Object> payload) {
        return given()
                .baseUri(baseUrl)
                .header("x-api-key", apiKey)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/users");
    }
    public static Response updateUser(int id, Map<String, Object> payload) {
        return given()
                .baseUri(baseUrl)
                .header("x-api-key", apiKey)
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .body(payload)
                .when()
                .put("/users/{id}");
    }
    public static Response patchUser(int id, Map<String, Object> payload) {
        return given()
                .baseUri(baseUrl)
                .header("x-api-key", apiKey)
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .body(payload)
                .when()
                .patch("/users/{id}");
    }
    public static Response deleteUser(int id) {
        return given()
                .baseUri(baseUrl)
                .header("x-api-key", apiKey)
                .pathParam("id", id)
                .when()
                .delete("/users/{id}");
    }
}
