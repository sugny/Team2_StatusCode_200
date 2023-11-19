package com.dietician.Request;
import com.dietician.Payload.DieticianLogin;
import com.dietician.Utilities.ExcelReader;

public class DietLoginPost {
	
	public DieticianLogin dataBuild() {
		DieticianLogin dl = new DieticianLogin();
		dl.setPassword((String) ExcelReader.setData().get(0));
		dl.setUserLoginEmail((String) ExcelReader.setData().get(1));
		return dl;
	}	
}
