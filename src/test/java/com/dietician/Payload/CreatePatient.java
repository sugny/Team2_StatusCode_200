package com.dietician.Payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatePatient {
	
	String FirstName;
	String LastName;
	String ContactNumber;
	String Email;
	String Allergy;
	String FoodCategory;
	String DateOfBirth;
	
	@JsonProperty("FirstName")
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	
	@JsonProperty("LastName")
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	@JsonProperty("ContactNumber")
	public String getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}
	
	@JsonProperty("Email")
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	@JsonProperty("Allergy")
	public String getAllergy() {
		return Allergy;
	}
	public void setAllergy(String allergy) {
		Allergy = allergy;
	}
	
	@JsonProperty("FoodCategory")
	public String getFoodCategory() {
		return FoodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		FoodCategory = foodCategory;
	}
	
	@JsonProperty("DateOfBirth")
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

}
