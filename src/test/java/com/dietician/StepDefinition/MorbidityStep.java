package com.dietician.StepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import org.junit.Assert;

import com.dietician.Request.DietLoginPost;
import com.dietician.RestAssuredBase.RestAssuredBase;
import com.dietician.RestAssuredBase.TokenHolder;
import com.dietician.Utilities.ConfigReader;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class MorbidityStep extends RestAssuredBase {
	DietLoginPost dietLoginPost = new DietLoginPost();
	RequestSpecification request;
	Response response;
	String asString;
		
	@Given("user is logged in as dietician")
	public void user_is_logged_in()  {
		Assert.assertNotNull(TokenHolder.token);
		}


	@When("user sends the Get request along with Bearer token")
	public void user_sends_the_Get_request_with_Bearer_token() {
		 request = given().spec(reqSpecBuilder());
	     response = request.header("Authorization", "Bearer " + TokenHolder.token).when().get(ConfigReader.getGlobalValue("morbidity"));
	    
	}
	
	@When("user sends the Get request with test name {string}")
	public void user_sends_the_Get_request_with_prameter(String testname) {
		request = given().spec(reqSpecBuilder());
		String base_url = ConfigReader.getGlobalValue("morbidity");
		String final_url = base_url + "/" + testname;
		response = request.header("Authorization", "Bearer " + TokenHolder.token).when().get(final_url);
		asString = response.then().log().all().extract().asString();
	    
	}
	
	@Then("user should get status code {int} OK in response")
	public void user_should_get_status_code_OK(Integer statuscode) {
		assertEquals(200 ,response.getStatusCode());
		asString = response.then().log().all().extract().asString();
	}

}
