package com.dietician.StepDefinition;

import java.util.ArrayList;
import java.util.List;

import com.dietician.ResponseBody.GetPatientDetailsResponse;
import com.dietician.RestAssuredBase.RestAssuredBase;
import com.dietician.RestAssuredBase.TokenHolder;
import com.dietician.Utilities.ConfigReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;

public class PatientControllerGetAndPutSteps extends RestAssuredBase {

	RequestSpecification contentType;

	@Given("User send get request with valid token")
	public void user_send_get_request_with_valid_token() {
		contentType = RestAssured.given().baseUri(ConfigReader.getGlobalValue("baseURL"))
				.header("Authorization", "Bearer "+TokenHolder.token).contentType(ContentType.JSON);
	}

	@And("get all patient details")
	public void get_all_patient_details() {

		List<GetPatientDetailsResponse> res = contentType.expect().defaultParser(Parser.JSON).when()
				.get(ConfigReader.getGlobalValue("getAllPatient"))
				.as(new TypeRef<ArrayList<GetPatientDetailsResponse>>() {
				});
		int size = res.size();
		GetPatientDetailsResponse deletePatientID = res.get(size - 1);
		System.out.println(res.get(size - 1));

	}

	@Then("verify the response body of get request")
	public void verify_the_response_body_of_get_request() {

	}

}
