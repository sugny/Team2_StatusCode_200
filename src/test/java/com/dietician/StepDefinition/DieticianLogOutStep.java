package com.dietician.StepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import com.dietician.RestAssuredBase.RestAssuredBase;
import com.dietician.RestAssuredBase.TokenHolder;
import com.dietician.Utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DieticianLogOutStep extends RestAssuredBase {
	
	RequestSpecification request;
	Response response;
	String asString;
		
	@Given("user enters the URL with valid endpoint")
	public void user_enters_the_URL_with_valid_endpoint() {
		request = given().spec(reqSpecBuilder()).header("Authorization", "Bearer "+TokenHolder.token);
		
	}

	@When("user sends the Get request with Authorizing the Bearer token")
	public void user_sends_the_Get_request_with_Authorizing_the_Bearer_token() {
	     response = request.when().get(ConfigReader.getGlobalValue("logOut"));
	    
	}

	@Then("user should get status code {int} OK")
	public void user_should_get_status_code_OK(Integer int1) {
		assertEquals(response.getStatusCode(),200);
		asString = response.then().log().all().extract().asString();
	}

	@Then("user should see the message {string} in response body")
	public void user_should_see_the_message_in_response_body(String string) {
		assertEquals(asString, "Logout successful");
	}

	

}
