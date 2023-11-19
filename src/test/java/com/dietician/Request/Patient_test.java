package com.dietician.Request;

import static io.restassured.RestAssured.given;

import java.io.File;

import com.dietician.Payload.PatientPayload;

import io.restassured.http.ContentType;
//import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Patient_test {
	
public static Response createBatch(PatientPayload payload)
	
	{
	
	File file=new File("C:/Users/shanj/OneDrive/Documents/HypoThyroid-Report.pdf");
		
	Response response = given().multiPart(file).multiPart("body",payload)
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
        .when().post(Routes.Post_CreatePatientUrl);
		return response ;
	}

}
