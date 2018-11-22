package assignmentQ10;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetPageTitles {
	static List <String> Titles = new ArrayList <String>();
	public static WebDriver driver;
	public static void main(String[] args){
		
		String chromepath = "./Resources/chromedriver";
		System.setProperty("webdriver.chrome.driver", chromepath+".exe");
		ChromeOptions obj_CO = new ChromeOptions();
		obj_CO.addArguments("windos-size=1400,800");
		obj_CO.addArguments("headless");
		WebDriver driver= new ChromeDriver(obj_CO);
		//driver.get("https://www.google.co.in");
		//System.setProperty("webdriver.firefox.marionette","geckodriver.exe");
		//driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Titles.add(driver.getTitle());
		List <WebElement> SubPagelinks = driver.findElements(By.tagName("a"));	
	
		for (int i=0; i<SubPagelinks.size();i++){
			WebElement elem = SubPagelinks.get(i);
			try{
			//String url= elem.getAttribute("href");
			elem.click();
			Titles.add(driver.getTitle());
			driver.navigate().back();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}

		} 
		
		System.out.println("All the titles are \n" + Titles);

}
}
