package chainingRequests;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithFile extends BaseInfo {

	
	@Test(dataProvider = " incidents")
	public void createRequest_multiData(String inputFile)
	{
		
		File dataFile=new File(inputFile);
		
		Response createIncidentResponse = specification.body(dataFile)
		.queryParam("sysparm_fields", "sys_id,short_description").post();
		
		
		 sysID = createIncidentResponse.jsonPath().get("result.sys_id");
		
	}
	
	@DataProvider(name =" incidents")
	public String[]  getData()
	{
		String[] input=new String[2];
		input[0]="./TestData/CreateRequestOne.json";
		input[1]="./TestData/CreateRequestTwo.json";
		return input;
	}

}
