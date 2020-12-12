package basics;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.response.Response;

public class ChangeRequests {
	
	
public static void main(String[] args) {
	//Preemptive --> to byepass the initial check call without Authentication
	int i=0;
	RestAssured.baseURI="https://dev96572.service-now.com/api/now/table";
	RestAssured.authentication = RestAssured.preemptive().basic("admin", "Tuna@123");
	Response response = RestAssured.given().queryParam("sysparm_fields", "number,sys_id,impact").queryParam("impact", "3")
	.get("change_request");
	response.prettyPrint();
	System.out.println(response.jsonPath().getList("result.impact").size());
	//To iterate through the response list
	System.out.println("------------------------");
	
	List<String> list = response.jsonPath().getList("result.sys_id");
//	for(String cr:list)
//	{
//		RestAssured.given().queryParam("sysparm_fields", "sys_id").get("change_request/"+cr).prettyPrint();
//		System.out.println(i++);
//	}
	
	//To get the inner fields
	
	Response response2 = RestAssured.given().get("change_request/"+list.get(1));
	response2.prettyPrint();
	System.out.println(response2.jsonPath().get("result.opened_by.value"));
}}
