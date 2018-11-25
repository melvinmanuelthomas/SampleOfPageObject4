package tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class RestAPITest {
    @Test
    public void getNobelLaureat() {
        RestAssured.baseURI = "http://api.nobelprize.org";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/v1/laureate.json");
        String responseBody = response.getBody().asString();
        assertThat(response.getBody().asString(),
                containsString("Paul Hermann"));
    }
    @Test
    public void getCityFromCountryStatusValidation() {
        RestAssured.baseURI = "http://api.nobelprize.org";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/v1/laureate.json");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
    }


}
