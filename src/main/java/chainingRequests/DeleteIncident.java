package chainingRequests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class DeleteIncident  extends BaseInfo{

	@Test(dependsOnMethods = {"chainingRequests.CreateIncidentWithFile.createRequest_multiData"} )
	public void deleteIncident() 
	{
		System.out.println(sysID);
		specification.delete("/incidents/"+sysID).then().assertThat().statusCode(204);
	}
}
