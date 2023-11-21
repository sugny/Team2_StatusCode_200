package com.dietician.RestAssuredBase;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

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
	
	public Object jsonToString(Response response, String key) {
		String responseBody = response.asString();
		JSONArray js = new JSONArray(responseBody);
		List<Object> patientList = new ArrayList<>();
		Object object = null;
		for(int i=0;i<js.length();i++) {
			JSONObject  obj = js.getJSONObject(i);
			object = obj.get(key);
			patientList.add(object);
		}
		return patientList;
	}

}
