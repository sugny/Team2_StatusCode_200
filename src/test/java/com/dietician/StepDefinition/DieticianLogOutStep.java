package com.dietician.StepDefinition;

import com.dietician.RestAssuredBase.RestAssuredBase;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DieticianLogOutStep extends RestAssuredBase {

	RequestSpecification request;
	Response response;
	String logOutResponse;
	Response invalidResponse;
	/*
	 * @Given("user enters the URL with valid endpoint") public void
	 * user_enters_the_URL_with_valid_endpoint() { request =
	 * given().spec(reqSpecBuilder()).header("Authorization",
	 * "Bearer "+TokenHolder.token);
	 * 
	 * }
	 * 
	 * @When("user sends the Get request with Authorizing the Bearer token") public
	 * void user_sends_the_Get_request_with_Authorizing_the_Bearer_token() {
	 * 
	 * response = request.when().get(ConfigReader.getGlobalValue("logOut"));
	 * logOutResponse = response.then().log().all().extract().asString();
	 * 
	 * 
	 * }
	 * 
	 * @Then("user should get status code {int} OK") public void
	 * user_should_get_status_code_OK(Integer int1) {
	 * assertEquals(response.getStatusCode(),200); }
	 * 
	 * @Then("user should see the message {string} in response body") public void
	 * user_should_see_the_message_in_response_body(String string) {
	 * assertEquals(logOutResponse, "Logout successful"); }
	 * 
	 * @When("user sends the Get request without Bearer token") public void
	 * user_sends_the_Get_request_without_Bearer_token() {
	 * 
	 * RequestSpecification reqSpec =
	 * given().spec(reqSpecBuilder()).header("Authorization", "Bearer ");
	 * invalidResponse =
	 * reqSpec.when().get(ConfigReader.getGlobalValue("logOut")).then().log().all().
	 * extract().response();
	 * 
	 * }
	 * 
	 * @But("user get status code {int} Unauthorized for invalid token") public void
	 * user_get_status_code_Unauthorized_for_invalid_token(Integer int1) {
	 * assertEquals(invalidResponse.getStatusCode(),401);
	 * assertEquals(rawToJson(invalidResponse, "error"),"Unauthorized"); }
	 */
}
