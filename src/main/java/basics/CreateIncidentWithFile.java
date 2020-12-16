package basics;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateIncidentWithFile {

	
	@Test(dataProvider = " incidents")
	public void createRequest_multiData(String inputFile)
	{
		
		File dataFile=new File(inputFile);

		//1) End Point
		RestAssured.baseURI="https://dev96572.service-now.com/api/now/table/incident";

		//2)Authorization
		RestAssured.authentication=RestAssured.basic("admin", "Tuna@123");


		//3)To post 
		RestAssured.given().log().all().contentType(ContentType.JSON).body(dataFile)
		.queryParam("sysparm_fields", "sys_id,short_description").post().prettyPrint();
	}
	
	@DataProvider(name =" incidents",parallel=true)
	public String[]  getData()
	{
		String[] input=new String[2];
		input[0]="./TestData/CreateRequestOne.json";
		input[1]="./TestData/CreateRequestTwo.json";
		return input;
	}

}
