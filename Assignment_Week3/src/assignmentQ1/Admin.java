package assignmentQ1;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Admin {
	 WebDriver driver;
	    Properties prop = new Properties();
	    By AdminMenu;
	    By UsrTxt;
	    String UsrVal;
	    By Role;
	    By EmpNm;
	    String EmpVal;
	    By Status;
	    By Search;
	    By reset;
	    By chk1;
	    By Add;
	    By SrchITm;
	    
		// Admin Class for Admin Page code
		public Admin(WebDriver driver){
		    this.driver=driver;
         FileInputStream fip;
			try {
				fip = new FileInputStream(System.getProperty("user.dir")+"\\src\\testData\\Or.Properties");
				prop.load(fip);
	             
			} catch (Exception e) {
			System.out.println(e.getMessage());
			}
 		
		}
		
		public void search(){
			AdminMenu = By.xpath(prop.getProperty("AdminMenu"));
		    UsrTxt = By.xpath(prop.getProperty("UsernameTxt"));
		   UsrVal =prop.getProperty("UsernameValue");
		    Role = By.xpath(prop.getProperty("UserRole"));
		    EmpNm =By.xpath(prop.getProperty("EmployeeName"));
		    EmpVal =prop.getProperty("EmployeeValue");
		    Status =By.xpath(prop.getProperty("Status"));
		    Search =By.xpath(prop.getProperty("searchButton"));
		    reset =By.xpath(prop.getProperty("ResetButton"));
		    chk1 =By.xpath(prop.getProperty("checkbox"));
		    Add =By.xpath(prop.getProperty("Add"));
		    SrchITm =By.xpath(prop.getProperty("AdminSearch"));
		    
		    /*Actions action = new Actions(driver);
			WebElement element = driver.findElement(AdminMenu);
			action.moveToElement(element).build().perform();
			action.moveToElement(element).click();
			action.build();*/
		driver.findElement(AdminMenu).click();
		driver.findElement(AdminMenu).click();
		driver.findElement(UsrTxt).sendKeys(UsrVal);
		driver.findElement(Role).sendKeys("All");
		driver.findElement(EmpNm).sendKeys(EmpVal);
		driver.findElement(Status).sendKeys("All");
		driver.findElement(Search).click();
		Assert.assertTrue(driver.findElement(SrchITm).isDisplayed());
		driver.findElement(chk1).click();
		driver.findElement(Add).click();
		}
		
		public void reset(){
			driver.findElement(reset).click();;
		}
}
