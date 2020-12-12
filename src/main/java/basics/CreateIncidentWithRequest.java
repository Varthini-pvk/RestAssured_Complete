package basics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateIncidentWithRequest {
	
	public static void main(String[] args) {
		
		
		//1) End Point
		RestAssured.baseURI="https://dev96572.service-now.com/api/now/table/incident";

		//2)Authorization
		RestAssured.authentication=RestAssured.basic("admin", "Tuna@123");
		
		
		//3)To post 
		RestAssured.given().log().all().contentType(ContentType.JSON).body("{\r\n" + 
				"\r\n" + 
				"    \"short_description\": \"varthini\"\r\n" + 
				"}").queryParam("sysparm_fields", "sys_id,short_description").post().prettyPrint();
}

}
