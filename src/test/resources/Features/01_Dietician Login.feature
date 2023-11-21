Feature: Dietician API TC:001 Dietician login and logout http request 

Scenario Outline: Dietcian login response with valid credentials 
	Given Add userLoginDto Payload from sheet "<Sheetname>"
	When User send post http request for Dietcian login 
	Then The API call got success with a status code 200 
	And Verify the response body
	Examples:
 	| Sheetname               |
    | dietician_User_login    |
	

Scenario Outline: Dietician create new patient using post request
	Given  Add new patient payload from sheet "<Sheetname>" and send post http request
	Then new patient created and verify status code 201
	And verify the response body created with patient
	Examples:
 	| Sheetname        |
    | CreatePatient    |

	
#Negative Scenario
#Scenario Outline: LoginIn with InValid UserName and Password 
#	Given user enters with invalid data from sheet "<Sheetname>"
#	When user sends the post request with Invalid emailid and password 
#	But user get status code 401 Unauthorized for invalid login
#	Examples:
# 	| Sheetname               |
#    | dietician_User_login    |

#Scenario: User Logout without Authorization
#	Given user enters the URL with valid endpoint
#    When user sends the Get request without Bearer token
#    But user get status code 401 Unauthorized for invalid token



	
#Scenario: User Logout with Authorization 
#	Given user enters the URL with valid endpoint 
#	When user sends the Get request with Authorizing the Bearer token 
#	Then user should get status code 200 OK 
#	And user should see the message "Logout successful" in response body 
#    