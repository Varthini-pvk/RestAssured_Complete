package baseLIB;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class baseWrappers 
{

	static String  configFolder="./src/main/resource/config";
	static String executionConfigFile="executionConfig";
	protected static Properties execConfig;
	static String serviceNowConfig="serviceNowDetails";
	static Properties snconfig;
	
	public static void getExecutionConfig() throws IOException
	{
		FileReader executionConfigReader=new FileReader(configFolder+executionConfigFile+".properties");
		execConfig.load(executionConfigReader);
		
	}
	
	public String getExecutionConfig(String propertyName)
	{
		return execConfig.getProperty(propertyName);
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
}
