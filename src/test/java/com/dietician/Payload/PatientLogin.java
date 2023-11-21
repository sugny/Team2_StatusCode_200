package com.dietician.Payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatientLogin {
	
	private String password;
	private String userLoginEmail;
	
	@JsonProperty("password")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonProperty("userLoginEmail")
	public String getUserLoginEmail() {
		return userLoginEmail;
	}
	
	public void setUserLoginEmail(String userLoginEmail) {
		this.userLoginEmail = userLoginEmail;
	}
	

	}
	
	
	

	


	

