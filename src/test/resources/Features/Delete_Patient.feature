@tag

Feature: Delete the patient


  Scenario Outline:  Deleting the patient
  	Given  The Dietician has logged in with his credentials "<sheetname>"
    When The Dietician is on the patient endpoint-delete patient "123"
    Then The dietician delets the patient with success 200-delete patient
     Examples:
 	  | Sheetname               |
    | dietician_User_login    |
	