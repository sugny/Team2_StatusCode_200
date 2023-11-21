Feature: Dietician API fetching all the morbidities and retrieve morbidity condition by test name 

Scenario: Fetching all the morbidities
	Given user is logged in as dietician
	When user sends the Get request along with Bearer token 
	Then user should get status code 200 OK in response
	

Scenario: Fetch a morbidity by test name 
	Given user is logged in as dietician 
	When user sends the Get request with test name "Plasma Glucose" 
	Then user should get status code 200 OK in response
	
	