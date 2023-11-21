package com.dietician.StepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import com.dietician.Payload.DieticianLogin;
import com.dietician.Payload.PatientLogin;


import com.dietician.PayloadBuilder.RequestPayloadBuilder;
import com.dietician.RestAssuredBase.RestAssuredBase;
import com.dietician.RestAssuredBase.TokenHolder;
import com.dietician.Utilities.ConfigReader;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class DeletePatientSteps extends RestAssuredBase {
	PatientLogin patientLogin=new PatientLogin ();
	DieticianLogin dl;
	
	RequestSpecification request;
	ResponseSpecification responseSpec;
	 Response response;
     String asString;
	 String testId;
	 int patientid;
	
	@Given("The Dietician has logged in with his credentials {string}")
	public void the_Dieticain_has_logged_in_with_his_credentials(String sheetName) {
		dl = RequestPayloadBuilder.dieticianLoginData(sheetName, "yes");
	    response = request.when().post(ConfigReader.getGlobalValue("login")).then().log().all().extract().response();
		TokenHolder.token = rawToJson(response,"token");
		System.out.println(TokenHolder.token);
		
	}
	
	@When("The Dietician is on the patient endpoint-delete patient {string}")
	public void the_Dietician_is_on_the_patient_endpoint_delete_patient( String Id ) {
		request = given().spec(reqSpecBuilder());
		String base_url = ConfigReader.getGlobalValue("patientURL");
		String final_url = base_url + "/" + ConfigReader.getGlobalValue("deletePatientID");
		System.out.println("Final URL: "+ final_url);
		String asString = response.then().log().all().extract().asString();
		response = request.header("Authorization", "Bearer " + TokenHolder.token).
				when().delete(final_url);
		response= RestAssured.given().delete();
	}



	@Then("The dietician delets the patient with success {int}-delete patient")
	public void the_dietician_delets_the_patient_with_success_delete_patient(Integer int1) {
		assertEquals(response.getStatusCode(),200);
		System.out.println("Deleted the patient");
	}

	
}