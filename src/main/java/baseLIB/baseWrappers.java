package baseLIB;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class baseWrappers 
{

	public static String  configFolder="./src/main/resources/config/";
	static String executionConfigFile="executionConfig";
	public static Properties execConfig;
	static String serviceNowConfig="serviceNowDetails";
	static Properties snconfig;
	
	public static void getExecutionConfig() throws IOException
	{
		execConfig=new Properties();
		FileReader executionConfigReader=new FileReader(configFolder+executionConfigFile+".properties");
		execConfig.load(executionConfigReader);
		
	}
	
	public static String getExecutionConfig(String propertyName)
	{
		return execConfig.getProperty(propertyName);
	}
	
	public static void setBaseURI(String endPoint)
	{
		RestAssured.baseURI=endPoint;
	}
	public static void setBaseAuthentication(String username,String password)
	{
		RestAssured.authentication = RestAssured.preemptive().basic(username, password);
	}
	
	
	public  Response getRequest(String resource)
	{
		return RestAssured.get();
	}
	public  ValidatableResponse verifyStatusCode(Response response, int code)
	{
		return response.then().statusCode(200);
	}
	
	public ValidatableResponse verifyContentTypeasJSon(Response response)
	{
		return response.then().contentType(ContentType.JSON);
	}
	
	
}
