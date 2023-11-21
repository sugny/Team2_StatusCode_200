package com.dietician.StepDefinition;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.dietician.Payload.CreatePatient;
import com.dietician.Payload.DieticianLogin;
import com.dietician.Request.PayloadBuilder;
import com.dietician.RestAssuredBase.RestAssuredBase;
import com.dietician.RestAssuredBase.TokenHolder;
import com.dietician.Utilities.ConfigReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DieticianLoginStep extends RestAssuredBase {
	

	DieticianLogin dl;
	RequestSpecification request;
	Response validResponse;
    List<Response> createPatientResponseList = new ArrayList<>();
	
	@Given("Add userLoginDto Payload from sheet {string}")
	public void add_userLoginDto_Payload_from_sheet(String sheetName) {
		dl=PayloadBuilder.dieticianLoginData(sheetName, "yes");
		request = RestAssured.given().baseUri(ConfigReader.getGlobalValue("baseURL")).body(dl).contentType(ContentType.JSON);
		
		
		/*request = given().spec(reqSpecBuilder()).body(DataBuilder.dieticianLoginData(sheetName, "yes"));
		
		RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri(ConfigReader.getGlobalValue("baseURL"))
				.setContentType(ContentType.JSON).build();*/
	}

	@When("User send post http request for Dietcian login")
	public void user_send_post_http_request_for_Dietcian_login()  {
		validResponse = request.when().post(ConfigReader.getGlobalValue("login")).then().log().all().extract().response();
		TokenHolder.token = rawToJson(validResponse,"token");
	}

	@Then("The API call got success with a status code {int}")
	public void the_API_call_got_success_with_a_status_code(Integer int1)  {
		assertEquals(200,validResponse.getStatusCode());
	}
	
	@And("Verify the response body")
	public void verify_the_response_body() {
         assertEquals(rawToJson(validResponse, "loginUserEmail"), dl.getUserLoginEmail());
	}
	 
	@Given("Add new patient payload from sheet {string} and send post http request")
	public void add_new_patient_payload_from_sheet_and_send_post_http_request(String sheetName) {    
	    List<CreatePatient> createPatientList = PayloadBuilder.createPatientData(sheetName);
	    for(CreatePatient patientInfo : createPatientList) {
		    Response patientResponse = RestAssured
			.given()
			.baseUri(ConfigReader.getGlobalValue("baseURL"))
			.config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()
					.encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
			.formParam("patientInfo", patientInfo)
			.multiPart("file", new File("C:\\Users\\Dumbledore\\Downloads\\HypoThyroidReport.pdf"), "application/pdf")
	        .header("Authorization","Bearer "+TokenHolder.token).post(ConfigReader.getGlobalValue("createNewPatient")).then().log().all().extract().response();	
		    createPatientResponseList.add(patientResponse);
	    }
	    
	}
	
	@Then("new patient created and verify status code {int}")
	public void new_patient_created_and_verify_status_code(Integer int1) {
		 for(Response r: createPatientResponseList)	{
			 assertEquals(201, r.getStatusCode());
			 assertEquals("application/json",r.contentType());
			 
		 }
	}

	@And("verify the response body created with patient")
	public void verify_the_response_body_created_with_patient() {
	   
	}


	
}