package assignmentQ2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

// to implement the listener class
@Listeners(assignmentQ2.Listener.class)

public class ImplementingListener extends GetSet {
	
	public WebDriver driver;
	String flag;
	Properties prop = new Properties();
	
	// this method is to open browser and url of the site before each test
	@BeforeMethod
	public void beforeMethod() throws Throwable{
		//System.out.println("In Before Suite- Opening Url");
		System.setProperty("webdriver.firefox.marionette","geckodriver.exe");
		FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+"\\src\\testData\\Or.Properties");
		prop.load(fip);
		 driver= new FirefoxDriver();
		 driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

	// this test is to check valid login functionality: eg of testcases with pass status
	@SuppressWarnings("deprecation")
	@Test (priority=1)
	public void login(){
		// valid username is set and then fetched later
		this.setName(prop.getProperty("userValidValue"));

		driver.findElement(By.xpath(prop.getProperty("usernameXpath"))).sendKeys(prop.getProperty("userValidValue"));
		driver.findElement(By.xpath(prop.getProperty("passwordXpath"))).sendKeys(prop.getProperty("passwordValue"));
		driver.findElement(By.xpath(prop.getProperty("LoginBtn"))).click();
		System.out.println("Test Data value" + this.getName());
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("LoginSuccess"))).isDisplayed());
		

		
		}
	
	// this test is to check valid login functionality but with invalid username: eg of testcases with fail status
	@SuppressWarnings("deprecation")
	@Test (priority=2)
	public void Inlogin(){
		// invalid username is set and then fetched later
		this.setName(prop.getProperty("userInValidValue"));
		driver.findElement(By.xpath(prop.getProperty("usernameXpath"))).sendKeys(prop.getProperty("userInValidValue"));
		driver.findElement(By.xpath(prop.getProperty("passwordXpath"))).sendKeys(prop.getProperty("passwordValue"));
		driver.findElement(By.xpath(prop.getProperty("LoginBtn"))).click();
		System.out.println("Test Data value" + this.getName());
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("LoginSuccess"))).isDisplayed());
		

	}
	
	//method to close browser after each method
	@AfterMethod
	public void afterMethod(){
		//System.out.println("In Before Suite- Opening Url");
		driver.close();
	}

}
