package com.dietician.StepDefinition;

import com.dietician.RestAssuredBase.RestAssuredBase;

public class PatientControllerSteps extends RestAssuredBase {
	
//	CreatePatientPost cp = new CreatePatientPost();
//	static String payload = "{\r\n"
//			+ "  \"FirstName\": \"sun\",\r\n"
//			+ "  \"LastName\": \"dori\",\r\n"
//			+ "  \"ContactNumber\": \"1122556699\",\r\n"
//			+ "  \"Email\": \"findingNemo@gmail.com\",\r\n"
//			+ "  \"Allergy\": \"Pecan\",\r\n"
//			+ "  \"FoodCategory\": \"Vegetarian\",\r\n"
//			+ "  \"DateOfBirth\": \"2010-06-21\"\r\n"
//			+ "}";
//	
	
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * 
	 * System.out.println(ConfigReader.getGlobalValue("baseURL"));
	 * System.out.println(ConfigReader.getGlobalValue("createNewPatient"));
	 * RequestSpecification header = RestAssured .given()
	 * .baseUri(ConfigReader.getGlobalValue("baseURL"))
	 * .config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()
	 * .encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
	 * .formParam("patientInfo", payload) .header(
	 * "Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdWdhbnlhbjc5NkBnbWFpbC5jb20iLCJpYXQiOjE3MDA1MTUwMTIsImV4cCI6MTcwMDU0MzgxMn0.f7Sa_NlF0xgkKEgTB3d1bsRuQlLKLhxjPm8wswF3J_6bNBRwYLfp3idgDPo_mX6P4z3x8elV6IbHUFEC4C7JJg"
	 * ));
	 * 
	 * header .post(ConfigReader.getGlobalValue("createNewPatient")) .then()
	 * .log().all() ; }
	 */
	
	/*
	 * @Given("Add new patient payload") public void add_new_patient_payload() {
	 * 
	 * CreatePatient patient = new CreatePatient(); patient.setFirstName("sun");
	 * patient.setLastName("dori"); patient.setContactNumber("1122556699");
	 * patient.setEmail("findingNemo@gmail.com"); patient.setAllergy("Pecan");
	 * patient.setFoodCategory("Vegetarian"); patient.setDateOfBirth("2010-06-21");
	 * System.out.println("********************************");
	 * System.out.println(TokenHolder.token);
	 * System.out.println(ConfigReader.getGlobalValue("baseURL"));
	 * System.out.println(ConfigReader.getGlobalValue("createNewPatient"));
	 * 
	 * RestAssured .given() .baseUri(ConfigReader.getGlobalValue("baseURL"))
	 * .config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()
	 * .encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
	 * .formParam("patientInfo", patient)
	 * .header("Authorization","Bearer "+TokenHolder.token).post(ConfigReader.
	 * getGlobalValue("createNewPatient")).then().log().all();
	 * 
	 * 
	 * 
	 * }
	 */
	 

	/*
	 * @When("Dietician calls {string} with {string} http request") public void
	 * dietician_calls_with_http_request(String string, String string2) {
	 * 
	 * 
	 * }
	 * 
	 * @Then("the API call got success with a status code {int}") public void
	 * the_API_call_got_success_with_a_status_code(Integer int1) {
	 * 
	 * 
	 * }
	 * 
	 * @And("verify the patient id created") public void
	 * verify_the_patient_id_created() {
	 * 
	 * 
	 * }
	 */

}
