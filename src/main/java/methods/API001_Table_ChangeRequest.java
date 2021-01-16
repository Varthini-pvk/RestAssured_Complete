package methods;

import baseLIB.commonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API001_Table_ChangeRequest extends commonMethods
{
	Response request;

	@Given("Set Endpoint")
	public static void setBaseURI()
	{
		System.out.println("enterec");
		//String property = execConfig.getProperty("servicenow_baseuri");
		RestAssured.baseURI="https://dev99435.service-now.com/api/now/table";
	}
	
	@And("Set basic Authention")
	public void serviceNow_BasicAuthentication()
	{
		setBaseAuthentication("admin","fed4vFpTO4YJ");
	}
	@When("Send the Get Request")
	public void getAllChangeRequest ()
	{
		request = RestAssured.get();
	}
	
	@Then("Validate the Status Code as (.*)$")
	public void validateStatusCode(int code)
	{
		verifyStatusCode(request,code);
	}
}
