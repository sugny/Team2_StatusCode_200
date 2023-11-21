package com.dietician.ResponseBody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class GetPatientDetailsResponse {
	
	 String patientId;
	 String firstName;
	 String lastName;
	 String email;
	
	 @JsonProperty("patientId")
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	@JsonProperty("FirstName")
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@JsonProperty("LastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@JsonProperty("Email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "PatientDetailsResponse [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + "]";
	}

}
