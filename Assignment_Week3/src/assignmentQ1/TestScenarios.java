package assignmentQ1;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestScenarios{

	WebDriver driver;
	Properties prop = new Properties();
	
	//Test Scenarios
	
	@BeforeTest
	public void beforeTest() throws Throwable{
		System.setProperty("webdriver.firefox.marionette","geckodriver.exe");
		FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+"\\src\\testData\\Or.Properties");
		prop.load(fip);
		 driver= new FirefoxDriver();
		 driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	@Test (priority=1, description="Scenario1")
	public void login(){
		LoginPage loginObj = new LoginPage(driver);
		loginObj.typeUserName(prop.getProperty("userValidValue"));
		loginObj.typePassword(prop.getProperty("passwordValue"));
		loginObj.submitPage();
		
	}
	
	@Test (priority=2, description="Scenario2")
	public void ValidateDirectoryClass(){
		Directory dirObj = new Directory(driver);
		
		dirObj.search();
		dirObj.reset();
	}
	
	@Test ( priority=3, description="Scenario3")
	public void ValidateAdminClass(){
		Admin AdObj = new Admin(driver);	
		AdObj.search();
		AdObj.reset();
	} 
	
	@Test ( priority=4, description="Scenario4")
	public void ValidateAssignLeaveClass(){
		AssignLeave ALObj = new AssignLeave(driver);	
		ALObj.assign();
	}
}







