package com.dietician.StepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import com.dietician.Request.DietLoginPost;
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


import org.junit.Assert;

public class GetALLPatientSteps extends RestAssuredBase{
	
	DietLoginPost Diet = new DietLoginPost();
	RequestSpecification request;
	ResponseSpecification responseSpec;
	Response validResponse;
	Response invalidResponse;
	Response response;
	String asString;
	
	

	@Given("User Login as Dietician")
	public void user_Login_as_Dietician() {
		
		request = given().spec(reqSpecBuilder()).header("Authorization", "Bearer "+TokenHolder.token);

		
		
	}
	@When("user Sends the Get request")
	public void user_Sends_the_Get_request() {
		
		
		request = given().spec(reqSpecBuilder());
		
		System.out.println(TokenHolder.token);
		
		System.out.println(ConfigReader.getGlobalValue("patient"));
		
		 response = request.header("Authorization", "Bearer "+TokenHolder.token)
				 .when().get(ConfigReader.getGlobalValue("patient"));
		 
		 asString = response.then().log().all().extract().asString();
	
		 
		 
	}

	@Then("should get Status code {int} ok")
	public void should_get_Status_code_ok(Integer int1) {
		
		assertEquals(200 ,response.getStatusCode());
		asString = response.then().log().all().extract().asString();
	}

	@Then("user Should get Patient Details in Response body")
	public void user_Should_get_Patient_Details_in_Response_body() {
	    
		
		
	}



}
