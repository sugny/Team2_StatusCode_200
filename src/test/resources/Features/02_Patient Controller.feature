Feature: Get all Patient 



Scenario: Get AlL Patient
Given User Login as Dietician
When user Sends the Get request 
Then should get Status code 200 ok
And user Should get Patient Details in Response body


