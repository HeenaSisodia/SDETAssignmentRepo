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

public class Directory {
	
	  WebDriver driver;
	    Properties prop = new Properties();
		
		public Directory(WebDriver driver){
		    this.driver=driver;
            FileInputStream fip;
			try {
				fip = new FileInputStream(System.getProperty("user.dir")+"\\src\\testData\\Or.Properties");
				prop.load(fip);
	             
			} catch (Exception e) {
			System.out.println(e.getMessage());
			}
    		
		}
		//search functionality
		public void search(){
			
			Actions action = new Actions(driver);
			/*WebElement element = driver.findElement(By.xpath(prop.getProperty("DirectoryMenu")));
			action.moveToElement(element).click().build().perform();*/
			driver.findElement(By.xpath(prop.getProperty("DirectoryMenu"))).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.findElement(By.xpath(prop.getProperty("DirectoryMenu"))).click();
			driver.findElement(By.xpath(prop.getProperty("Name"))).sendKeys(prop.getProperty("NameValue"));
			Select titledrpdwn = new Select(driver.findElement(By.xpath(prop.getProperty("Title"))));
			Select locdrpdwn = new Select(driver.findElement(By.xpath(prop.getProperty("Location"))));
			titledrpdwn.selectByVisibleText(prop.getProperty("TitleValue"));
			//locdrpdwn.selectByVisibleText(prop.getProperty("LocationValue"));
			locdrpdwn.selectByIndex(5);
			driver.findElement(By.xpath(prop.getProperty("searchButton"))).click();
			String searchItmActual = driver.findElement(By.xpath(prop.getProperty("searchResult"))).getText();
			String searchItmExpected = prop.getProperty("searcResultVal");
			//System.out.println(searchItmActual);
			//System.out.println(searchItmExpected);
			Assert.assertEquals(searchItmActual, searchItmExpected);

		}
		
		public void reset(){
			driver.findElement(By.xpath(prop.getProperty("ResetButton"))).click();
		}

}
