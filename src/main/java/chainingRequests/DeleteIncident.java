package chainingRequests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteIncident  extends BaseInfo{

	@Test(dependsOnMethods = {"chainingRequests.CreateIncidentWithFile.createRequest_multiData"} )
	public void deleteIncident() 
	{
		System.out.println(sysID);
		System.out.println(specification.delete("/incidents/"+sysID).getStatusCode());
	}
}
