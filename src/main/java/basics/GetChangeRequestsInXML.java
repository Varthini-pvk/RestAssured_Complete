package basics;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.text.DateFormatter;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetChangeRequestsInXML
{
	
	@Test
	public void getChangeRequest()
	{
		LocalDate date=LocalDate.now();
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		String format = date.format(ofPattern);
		System.out.println(format);
		RestAssured.baseURI="https://dev96572.service-now.com/api/now/table/change_request";
		RestAssured.authentication=RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured.given().queryParam("sysparm_fields", "number,sys_id,sys_created_on").accept(ContentType.XML).get();
		response.prettyPrint();
		 List<Object> list = response.xmlPath().getList("response.result");
		 System.out.println(list.size());
	}
	
	
}
