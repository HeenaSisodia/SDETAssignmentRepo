package assignmentQ1;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AssignLeave {
	 WebDriver driver;
	    Properties prop = new Properties();
	    By LeaveMenu;
	    By AssignLeave;
	    By EmpNm;
	    String EmpVal;
	    By Type;
	    By FromDate;
	    String FromDateVal;
	    By ToDate;
	    String ToDateVal;
	    By Comment;
	    By Assign;
	    
		//AssignLeave Class for AssignLeave page code
		public AssignLeave(WebDriver driver){
		    this.driver=driver;
      FileInputStream fip;
			try {
				fip = new FileInputStream(System.getProperty("user.dir")+"\\src\\testData\\Or.Properties");
				prop.load(fip);
	             
			} catch (Exception e) {
			System.out.println(e.getMessage());
			}
		
		}
		
		public void assign(){
			LeaveMenu = By.xpath(prop.getProperty("LeaveMenu"));
			AssignLeave = By.linkText("Assign Leave");
		    EmpNm =By.xpath(prop.getProperty("ALEmpNm"));
		    EmpVal =prop.getProperty("ALEmpVal");
		    Type=By.xpath(prop.getProperty("ALTyp"));
		    FromDate =By.xpath(prop.getProperty("ALfromDt"));
		    FromDateVal=prop.getProperty("fromDt");
		    ToDate =By.xpath(prop.getProperty("ALToDt"));
		    ToDateVal=prop.getProperty("toDt");
		    Comment =By.xpath(prop.getProperty("ALComment"));
		    Assign =By.xpath(prop.getProperty("AssignBtn"));
		    
		    
		    /*Actions action = new Actions(driver);
		WebElement element = driver.findElement(LeaveMenu);
		action.moveToElement(element).perform();
		WebElement subElement = driver.findElement(By.partialLinkText("Assign"));
		 
        action.moveToElement(subElement);
 
        action.click();
 
        action.perform();*/
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(LeaveMenu).click();
        driver.findElement(AssignLeave).click();
		driver.findElement(EmpNm).sendKeys(EmpVal);
		driver.findElement(Type).sendKeys("FMLA US");
		driver.findElement(FromDate).clear();
		driver.findElement(FromDate).sendKeys(FromDateVal);
		driver.findElement(ToDate).clear();
		driver.findElement(ToDate).sendKeys(ToDateVal);
		driver.findElement(Comment).sendKeys("Test Leave");
		driver.findElement(Assign).click();

		}
}
