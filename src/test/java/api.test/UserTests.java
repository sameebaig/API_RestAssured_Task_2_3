import api.endpoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

//tc passed
public class UserTests {

    static int userId;
    @Test(priority = 1)
    public void fetchUserList() {
        Response response = UserEndPoints.getUserList();
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200); 
        Assert.assertEquals(response.jsonPath().getInt("total_pages"), 2);
        Assert.assertEquals(response.jsonPath().getInt("total"), 12);
    }
    @Test(priority = 2)
    public void createNewEmployee() {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Sameen");
        data.put("job", "QA");

        Response response = UserEndPoints.createUser(data);
        response.then().log().all();

        Assert.assertEquals(response.statusCode(), 201); //201
        userId = response.jsonPath().getInt("id");
        System.out.println("Created User ID: " + userId);
    }
    @Test(priority = 3)
    public void updateEmployee() {
        Map<String, Object> updatedData = new HashMap<>();
        updatedData.put("name", "John Updated");
        updatedData.put("job", " QA");

        Response response = UserEndPoints.updateUser(userId, updatedData);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200); //200
        Assert.assertEquals(response.jsonPath().getString("name"), "John Updated");
    }
    @Test(priority = 4)
    public void patchEmployee() {
        Map<String, Object> patchData = new HashMap<>();
        patchData.put("job", "QA");

        Response response = UserEndPoints.patchUser(userId, patchData);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200); //200
        Assert.assertEquals(response.jsonPath().getString("job"), "QA");
    }
    @Test(priority = 5)
    public void deleteEmployee() {
        Response response = UserEndPoints.deleteUser(userId);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 204);//204
    }
}
