package chainingRequests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseInfo 
{

	public RequestSpecification specification=null;
	static String  sysID="";
	
	@BeforeMethod
	public void init()
	{
				//1) End Point
				RestAssured.baseURI="https://dev96572.service-now.com/api/now/table";

				//2)Authorization
				RestAssured.authentication=RestAssured.basic("admin", "Tuna@123");
				
				 specification = RestAssured.given().log().all().contentType(ContentType.JSON);
	}
}
