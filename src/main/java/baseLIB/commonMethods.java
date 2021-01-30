package baseLIB;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.jetty.client.util.BasicAuthentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class commonMethods extends baseWrappers {
	
	static String serviceNowConfig="serviceNowDetails";
	public static Properties snconfig;
	

	public static void getserviceNowDetails() throws IOException
	{
		snconfig=new Properties();
		FileReader serviceNowConfigReader=new FileReader(configFolder+serviceNowConfig+".properties");
		snconfig.load(serviceNowConfigReader);
		
		
	}
	
	
	
	

	
}


