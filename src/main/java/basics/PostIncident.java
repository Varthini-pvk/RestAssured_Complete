package basics;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostIncident {

	public static void main(String[] args) {
		
	
			//1) End Point
			RestAssured.baseURI="https://dev96572.service-now.com/api/now/table/incident";

			//2)Authorization
			RestAssured.authentication=RestAssured.basic("admin", "Tuna@123");
			
			
			//3)To post 
			RestAssured.given().log().all().contentType(ContentType.JSON).post().prettyPrint();
	}
}
