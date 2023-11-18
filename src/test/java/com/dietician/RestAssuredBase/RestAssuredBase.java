package com.dietician.RestAssuredBase;

import com.dietician.Utilities.ConfigReader;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestAssuredBase {
	
	public RequestSpecification reqSpecBuilder() {
		RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri(ConfigReader.getGlobalValue("baseURL"))
				.setContentType(ContentType.JSON).build();
		return reqSpec;
	}
	
	public ResponseSpecification resSpecBuilder() {
		ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build().then().log().all();
		return resSpec;
	}
	
	public String rawToJson(Response response, String key) {
		String getResponse = response.asString();
		JsonPath js = new JsonPath(getResponse);
		String value = js.get(key);
		return value;
	}

}
