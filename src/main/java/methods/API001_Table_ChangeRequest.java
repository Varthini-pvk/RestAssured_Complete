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
	
	@Then("verify Response contentType")
	public void validateContentTypeAsJSON()
	{
		verifyContentTypeasJSon(request);
	}
}
