package basics;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetIncidents {

	public static void main(String[] args) {

//Used RestAssured Assertions

		//1) End Point
		RestAssured.baseURI="https://dev96572.service-now.com/api/now/table/incident";

		//2)Authorization
		RestAssured.authentication=RestAssured.basic("admin", "Tuna@123");

		//3)Get the request
		//With query parameters
		//to change accept time
		Response response = RestAssured.given().queryParam("sysparm_fields","number,sys_id")
				.accept("application/xml")
				.get();

		

		//To get IncidentCount

		//			JsonPath jsonPath = response.jsonPath();
		//		 List<String> list = jsonPath.getList("result.sys_id");
		//		 System.out.println(list.size());

		
		//To get IncidentCount

			XmlPath xmlPath = response.xmlPath();
			List<String> list = xmlPath.getList("response.result.sys_id");
			System.out.println(list.size());



	}

}
