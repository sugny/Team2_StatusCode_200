package com.dietician.Request;

import io.restassured.specification.RequestSpecification;

public class Routes {

	public static String base_url="https://dietician-dev-41d9a344a720.herokuapp.com/dietician";
    
    //Program module
     public static String Post_CreatePatientUrl=base_url+"/patient";
    
     public static String Get_allPatientUrl= base_url+"/patient";
     public static String Put_PatientUrl= base_url+"/patient/{patientId}";
     
    
	
}


/*
 Post_CreatePatientUrl:/patient
 Get_allPatientUrl:/patient
 Put_PatientUrl:/patient/patientId/
 Get_PatientReport_byPatientId:/patient/testReports/patientId/
 Get_PatientReport_byfileId:/patient/testReports/viewFile/fileId/
 Delete_Patient_byPatientId:/patient/patientId/
 */