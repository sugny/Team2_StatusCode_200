package com.dietician.RestAssuredBase;

import com.dietician.Utilities.ConfigReader;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredBase {
	
	public RequestSpecification reqSpecBuilder() {
	    return RestAssured
			.given()
			.baseUri(ConfigReader.getGlobalValue("baseURL"))
	        .header("Authorization","Bearer "+TokenHolder.token);
	}
	
		
	public String rawToJson(Response response, String key) {
		String getResponse = response.asString();
		JsonPath js = new JsonPath(getResponse);
		String value = js.get(key);
		return value;
	}

}
