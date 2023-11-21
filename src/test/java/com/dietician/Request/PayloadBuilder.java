package com.dietician.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dietician.Payload.CreatePatient;
import com.dietician.Payload.DieticianLogin;
import com.dietician.Utilities.ExcelReader;

public class PayloadBuilder {

	
	public static DieticianLogin dieticianLoginData(String sheetName, String valid) {
		List<Map<String, String>> data = ExcelReader.getInstance().getData(sheetName);
		DieticianLogin dl = null;
		for (Map<String, String> d : data) {
			 dl= new DieticianLogin();
			if (d.get("valid").equalsIgnoreCase(valid)) {
			dl.setUserLoginEmail(d.get("userLoginEmail"));
			dl.setPassword( d.get("password"));
			break; // Just get the first valid credentials
			}
		}
		return dl;
	}

	public static List<CreatePatient> createPatientData(String sheetName) {
		List<Map<String, String>> data = ExcelReader.getInstance().getData(sheetName);
		List<CreatePatient> cpList = new ArrayList<>();
		for(Map<String, String> d : data) {
			CreatePatient patient = new CreatePatient();
			patient.setFirstName(d.get("FirstName"));
			patient.setLastName(d.get("LastName"));
			patient.setContactNumber(d.get("ContactNumber"));
		    patient.setEmail(d.get("Email"));
		    patient.setAllergy(d.get("Allergy"));
		    patient.setFoodCategory(d.get("FoodCategory"));
		    patient.setDateOfBirth(d.get("DateOfBirth"));
			cpList.add(patient);
		}
		return cpList;
	}
}
