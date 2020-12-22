package WireMock;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.client.WireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class PostIncident_Stub 

{
	@BeforeMethod
	public void mockgetIncidents()
	{
		configureFor("localhost", 8091);
		WireMock.stubFor(post("/api/now/table/incident")
				.withBasicAuth("admin", "Tuna@123")
				.withRequestBody(equalToJson("{\"name\":\"test\"}"))
				.willReturn(aResponse().withBody("{\"result\":\"done\"}").withStatus(201)));
	}

	@Test
	public static void getIncidents() {



		//1) End Point
		RestAssured.baseURI="http://localhost:8091/api/now/table/incident";
		RestAssured.useRelaxedHTTPSValidation();

		//2)Authorization
		//RestAssured.authentication=RestAssured.basic("admin", "Tuna@123");

	
		Response response = RestAssured.given().header("Authorization","Basic YWRtaW46VHVuYUAxMjM=").log().all().body("{\"name\":\"test\"}")
				.post();

		//To Print Response
		response.prettyPrint();

		//To Print Status Code:
		System.out.println(response.getStatusCode());


	}


}
