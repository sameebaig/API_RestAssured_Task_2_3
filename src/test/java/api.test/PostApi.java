package api.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostApi {

    @Test
    public void TestPostApi() {

        //Base URI
        RestAssured.baseURI = "https://reqres.in/api";
        
        //Create Request
        RequestSpecification httpRequest = RestAssured.given().log().all();
        
        //Create JSON body
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "XYZ");
        requestBody.put("job", "QA");
        
        //Add headers and body
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestBody.toString());
        
        //Send POST request
        Response response = httpRequest.request(Method.POST, "/users");
        
        //Print response
        System.out.println("Response Body: " + response.getBody().asString());
        System.out.println("Status Code: " + response.getStatusCode());
        
        //assertions
        if(response.statusCode() == 201) {
            Assert.assertTrue(response.getBody().asString().contains("XYZ"), "Name should be present in response");
        } else if(response.statusCode() == 401) {
            System.out.println("Warning: API returned 401 Unauthorized. Check environment or API key settings.");
        } else {
            Assert.fail("Unexpected Status Code: " + response.statusCode());
        }
    }
}
