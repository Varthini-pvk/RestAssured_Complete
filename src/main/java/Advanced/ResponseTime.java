package Advanced;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseTime 
{
	@Test
	public void getUsers()
	{
		RestAssured.baseURI="https://gorest.co.in/public-api/users";
		//To use Brearer Token
		Response response = RestAssured.given().header("Authorization","Bearer e49f3f858dd8e7ead8ffe4a22662c3eabecd89b884a28db3d88ff97327e39c11")
		.queryParam("created_at", LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE)).get();
		response.prettyPrint();
		//To Print the response Time
//		System.out.println(response.then().time(lessThan(2),TimeUnit.SECONDS); 	
	}

}
