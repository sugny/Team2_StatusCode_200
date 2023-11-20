           
  package com.dietician.Request;
  
 import java.util.List;

import com.dietician.Payload.PatientLogin;
import com.dietician.Utilities.ExcelReader;

  
  
  public class PatientloginPost {
      static List<String> excelData;
       public PatientloginPost() {
    	   
      excelData = ExcelReader.getExcelData("PatientLogin");
      }
       
      public static PatientLogin validData() {
      	PatientLogin P2 = new PatientLogin();
      P2.setPassword(excelData.get(0));
       P2.setUserLoginEmail(excelData.get(1));
      return P2;
  }
      
  
	
	  public static PatientLogin invalidData() { 
		  PatientLogin P2 = new PatientLogin();
	  P2.setPassword(excelData.get(2));
	  P2.setUserLoginEmail(excelData.get(3));
	  return P2; }
	  
	  }
	 