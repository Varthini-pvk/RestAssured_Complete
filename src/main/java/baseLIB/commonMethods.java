package baseLIB;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class commonMethods extends baseWrappers {
	
	
	public static void setBaseURI(String application)
	{
		RestAssured.baseURI=execConfig.getProperty(application+"_baseuri");
	}
	
	
	public static void serviceNow_BasicAuthentication(String application)
	{
		
	}
	
//	public Response getResponse(String Resource)
//	{
//		//setBaseAuthentication()
//	}

}


