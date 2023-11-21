package com.dietician.Hooks;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import com.dietician.Utilities.ConfigReader;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class Hooks {
	
	public static RequestSpecification reqSpec;
	
	@Before
	public RequestSpecification requestSpec() throws IOException {
		if(reqSpec==null) {
		PrintStream ps = new PrintStream(new FileOutputStream("logging.txt"));
		reqSpec = new RequestSpecBuilder().setBaseUri(ConfigReader.getGlobalValue("baseURL"))
										.addFilter(RequestLoggingFilter.logRequestTo(ps))
										.addFilter(ResponseLoggingFilter.logResponseTo(ps)).build();
		return reqSpec;
		}
		else
			return reqSpec;
	}


}
