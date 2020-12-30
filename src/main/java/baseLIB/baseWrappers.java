package baseLIB;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;

public class baseWrappers 
{

	static String  configFolder="./src/main/resource/config";
	static String executionConfigFile="executionConfig";
	static Properties execConfig;
	
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
}
