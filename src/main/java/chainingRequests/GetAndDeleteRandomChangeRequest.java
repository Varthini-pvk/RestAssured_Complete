package chainingRequests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class GetAndDeleteRandomChangeRequest extends BaseInfo
{
	@Test
	public void getReq()
	{
		Response response = specification.get("/change_request");
		response.prettyPrint();
		List<String> list = response.jsonPath().getList("result.sys_id");
		System.out.println(list.size());
		int reqNUmber=0 + ((int)Math.random() * (list.size() - 0));
		sysID=list.get(reqNUmber);
		
	}
	
	@Test(dependsOnMethods = "getReq")
	public void delCR()
	{
		Response deleteResponse = specification.delete("/change_request/"+sysID);
		deleteResponse.prettyPrint();
		Assert.assertEquals(deleteResponse.getStatusCode(), 204);
	}

}
