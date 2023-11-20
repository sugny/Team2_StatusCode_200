package com.dietician.StepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import com.dietician.Request.PatientloginPost;
import com.dietician.RestAssuredBase.RestAssuredBase;
import com.dietician.RestAssuredBase.TokenHolder;
import com.dietician.Utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PatientLoginStep extends RestAssuredBase{
	
	PatientloginPost patientLoginPost = new PatientloginPost(); 
	RequestSpecification request;
	ResponseSpecification responseSpec;
	Response validResponse;
	Response invalidResponse;
	

	@Given("User Login and enters the URL")
	public void user_Login_and_enters_the_URL() {
	    
		request = given().spec(reqSpecBuilder()).body(PatientloginPost.validData());
	}
	

	@When("user sends the post request with valid emailid and valid password")
	public void user_sends_the_post_request_with_valid_emailid_and_valid_password() {
	    
		validResponse = request.when().post(ConfigReader.getGlobalValue("login")).then().log().all().extract().response();
		TokenHolder.token = rawToJson(validResponse,"token");
		
		System.out.println(TokenHolder.token);
		
		
		
		}
		
	

	@Then("should get status code {int} OK")
	public void should_get_status_code_OK(Integer int1) {
	    
		assertEquals(validResponse.getStatusCode(),200);
		
	}
	
}