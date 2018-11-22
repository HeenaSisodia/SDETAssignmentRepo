package assignmentQ7;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class getPropertiesValues {

	
	public static void main (String args[]) throws Throwable{
		Properties properties = new Properties();
		FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+"\\src\\testData\\Or.Properties");
		properties.load(fip);
		for(String key : properties.stringPropertyNames()) {
			  String value = properties.getProperty(key);
			  System.out.println(key + " => " + value);
			}
	}
}
