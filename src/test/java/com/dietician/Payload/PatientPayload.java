package com.dietician.Payload;

public class PatientPayload {
	
	//public static Object setFirstName;
	public static String FirstName;
	 String LastName;
	 Integer ContactNumber;
	 String Email;
	 String Allergy;
	 String FoodCategory;
	 String DateOfBirth;
	 
	 
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	
   public Integer getContactNumber() {
		
		return ContactNumber;	
	}
	public void setContactNumber(Integer ContactNumber) {
		
		this.ContactNumber = ContactNumber;
	}
	
	public String Email() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String Allergy() {
		return Allergy;
	}
	public void setAllergy(String Allergy) {
		this.Allergy = Allergy;
	}
	
	public String FoodCategory() {
		return FoodCategory;
	}
	public void setFoodCategory(String FoodCategory) {
		this.FoodCategory = FoodCategory;
	}
	
	public String DateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String DateOfBirth) {
		this.DateOfBirth = DateOfBirth;
	}
	
	

}


