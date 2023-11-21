package com.dietician.StepDefinition;


import static org.junit.Assert.*;


import com.dietician.Payload.PatientLogin;
import com.dietician.request.PayloadBuilder;
import com.dietician.RestAssuredBase.RestAssuredBase;
import com.dietician.RestAssuredBase.TokenHolder;
import com.dietician.Utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatientLoginStep extends RestAssuredBase{

	PatientLogin P1;
	RequestSpecification request;
	Response validResponse;
	
	
	@Given("user Add userLoginDto Payload from sheet {string}")
	public void user_Add_userLoginDto_Payload_from_sheet(String patient_login) {
	    
		P1=PayloadBuilder.PatientLoginData(patient_login,"yes");
		request = RestAssured.given().baseUri(ConfigReader.getGlobalValue("baseURL")).body(P1).contentType(ContentType.JSON);	
		

	}
	
	@When("User send post http request for Patient login")
	public void user_send_post_http_request_for_Patient_login() {
	    validResponse = request.when().post(ConfigReader.getGlobalValue("login")).then().log().all().extract().response();
		TokenHolder.token = rawToJson(validResponse,"token");
		
		
	}

	@Then("The API call got success with a status code {int} OK")
	public void the_API_call_got_success_with_a_status_code_OK(Integer int1) {
		assertEquals(200,validResponse.getStatusCode());
	    }

	@Then("Verified the response body")
	public void verified_the_response_body() {
	   
		
	}



	
}

