
Feature: Patient API  Patientlogin and logout http request 

Scenario Outline: Patient login response with valid credentials 
	Given user Add userLoginDto Payload from sheet "<Sheetname>"
	When User send post http request for Patient login 
	Then The API call got success with a status code 200 OK
	And Verified the response body
	
	Examples:
 	| Sheetname           |
    | patient_login     |
	
	
