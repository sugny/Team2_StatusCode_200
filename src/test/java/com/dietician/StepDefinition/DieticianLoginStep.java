package com.dietician.StepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import com.dietician.Request.DietLoginPost;
import com.dietician.RestAssuredBase.RestAssuredBase;
import com.dietician.RestAssuredBase.TokenHolder;
import com.dietician.Utilities.ConfigReader;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class DieticianLoginStep extends RestAssuredBase {
	
	DietLoginPost dietLoginPost = new DietLoginPost(); 
	RequestSpecification request;
	ResponseSpecification responseSpec;
	Response response;
	
	@Given("Add userLoginDto Payload")
	public void add_userLoginDto_Payload()  {
		request = given().spec(reqSpecBuilder()).body(dietLoginPost.dataBuild());
	}

	@When("User send post http request for Dietcian login")
	public void user_send_post_http_request_for_Dietcian_login()  {
		response = request.when().post(ConfigReader.getGlobalValue("login")).then().log().all().extract().response();
		TokenHolder.token = rawToJson(response,"token");
		System.out.println(TokenHolder.token);	
	}

	@Then("The API call got success with a status code {int}")
	public void the_API_call_got_success_with_a_status_code(Integer int1)  {
		assertEquals(response.getStatusCode(),200);
	}
	
	@And("Verify the response body")
	public void verify_the_response_body() {
           
	}


}
