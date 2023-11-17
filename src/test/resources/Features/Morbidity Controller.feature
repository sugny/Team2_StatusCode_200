Feature: Dietician API Validating User login and logout module

Scenario: Dietcian login response with valid credentials
Given Add userLoginDto Payload 
When User send get http request for Dietcian login
Then The API call got success with a status code 200
And Verify the body and get token from payload 
	