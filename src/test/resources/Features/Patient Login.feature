@Patientlogin
Feature: LoginIn 
I want to use this template for my feature file


 @tc_01 
Scenario: Patient login response with valid credentials
Given User Login and enters the URL
When user sends the post request with valid emailid and valid password
Then should get status code 200 OK




 @tc_03
Scenario: Patient Logout with Authorization 
	Given user enters the URL 
	When user hit the  Get request with Authorizing the Bearer token 
	Then user see status code 200 OK 
	And user Get message "Logout successful" in response body












