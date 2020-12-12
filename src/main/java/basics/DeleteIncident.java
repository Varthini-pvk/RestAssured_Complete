package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteIncident {

	@Test
	public void deleteIncident() 
	{
		RestAssured.baseURI="https://dev96572.service-now.com/api/now/table";
		RestAssured.authentication = RestAssured.preemptive().basic("admin", "Tuna@123");
	}
}
