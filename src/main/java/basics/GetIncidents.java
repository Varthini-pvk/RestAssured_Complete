package basics;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetIncidents {
	
	public static void main(String[] args) 
	{
		//1) End Point
		RestAssured.baseURI="https://dev96572.service-now.com/api/now/table/incident";
		
		//2)Authorization
		RestAssured.authentication=RestAssured.basic("admin", "Tuna@123");
		
		//3)Get the request
		Response response = RestAssured.get();
		
		//To Print Response
		response.prettyPrint();
		
		//To Print Status Code:
		System.out.println(response.getStatusCode());
		
	}

}
