package StepDefs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ApiTest {
    @Test
    public void ApiTest() {
        Response response = RestAssured.get("https://api.agify.io/?name=meelad");
        assertEquals(200, response.getStatusCode());
        String name = response.jsonPath().getString("name");
        assertEquals(name, "meelad", "Name mismatch in the response");
        int age = response.jsonPath().getInt("age");
        System.out.println(name+age);
        assertEquals(age, 33, "Age mismatch in the response");
    }
}
