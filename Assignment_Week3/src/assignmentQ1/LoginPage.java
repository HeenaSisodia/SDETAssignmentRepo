package assignmentQ1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    Properties prop = new Properties();
    By username;
    By password;

    
    public LoginPage(WebDriver driver)
    {
             this.driver=driver;
             FileInputStream fip;
			try {
				fip = new FileInputStream(System.getProperty("user.dir")+"\\src\\testData\\Or.Properties");
				prop.load(fip);
	             
			} catch (Exception e) {
			System.out.println(e.getMessage());
			}
     		
 
    }

    public void typeUserName(String uid)
    {
        username =  By.xpath(prop.getProperty("usernameXpath"));    
    	driver.findElement(username).sendKeys(uid);
                                   
    }

    public void typePassword(String pass)
    {
   
    	password =  By.xpath(prop.getProperty("passwordXpath"));      
    	driver.findElement(password).sendKeys(pass);
                                      
    }
    
    public void submitPage(){
    	
    	password =  By.xpath(prop.getProperty("passwordXpath"));
    	driver.findElement(password).submit();
    }


    

}
