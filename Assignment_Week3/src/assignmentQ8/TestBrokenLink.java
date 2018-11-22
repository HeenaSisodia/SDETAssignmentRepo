package assignmentQ8;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBrokenLink {
	static List <String> linkPass = new ArrayList <String>();
	static List <String> linkFail = new ArrayList <String>();
	static int totalLinks;
	public static WebDriver driver;
	public static void main(String[] args){
		System.setProperty("webdriver.firefox.marionette","geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		List <WebElement> links = driver.findElements(By.tagName("a"));
				
		for (int i=0; i<links.size();i++){
			WebElement ele = links.get(i);
			String url= ele.getAttribute("href");
			//System.out.println("urls ---->" +url);
			ValidateLinks(url);
			
		}
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		List <WebElement> SubPagelinks = driver.findElements(By.tagName("a"));
		totalLinks = links.size() + SubPagelinks.size();
		System.out.println("Total links" + totalLinks);
		
	
		for (int i=0; i<SubPagelinks.size();i++){
			WebElement elem = SubPagelinks.get(i);
			try{
			String url= elem.getAttribute("href");
			ValidateLinks(url);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}

				
		}
		
		System.out.println("Links Passed" + linkPass);
		System.out.println("Links Failed" + linkFail);
		
	}
	
	public static void ValidateLinks(String linkUrl){
		try{
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection)url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();
			
			if(httpURLConnect.getResponseCode()!= 200){
				//System.out.println(linkUrl + "----- Status is not 200");
				linkFail.add(linkUrl + "status is not 200");
			}
			if(httpURLConnect.getResponseCode()== 200){
				//System.out.println(linkUrl + "---" + httpURLConnect.getResponseMessage());
				linkPass.add(linkUrl +httpURLConnect.getResponseMessage());
			}
			
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

	
}
