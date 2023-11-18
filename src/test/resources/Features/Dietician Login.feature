Feature: Dietician API Validating User login and logout module 

Scenario: Dietcian login response with valid credentials 
	Given Add userLoginDto Payload 
	When User send post http request for Dietcian login 
	Then The API call got success with a status code 200 
	And Verify the response body 
	
Scenario: User Logout with Authorization 
	Given user enters the URL with valid endpoint 
	When user sends the Get request with Authorizing the Bearer token 
	Then user should get status code 200 OK 
	And user should see the message "Logout successful" in response body