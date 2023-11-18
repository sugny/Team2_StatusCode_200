package com.dietician.Request;

import com.dietician.Payload.DieticianLogin;
import com.dietician.Utilities.ExcelReader;

public class DietLoginPost {
	ExcelReader er = new ExcelReader();
	
	public DieticianLogin dataBuild() {
		DieticianLogin dl = new DieticianLogin();
		dl.setPassword(er.getCellData().get(0));
		dl.setUserLoginEmail(er.getCellData().get(1));
		return dl;
	}

}
