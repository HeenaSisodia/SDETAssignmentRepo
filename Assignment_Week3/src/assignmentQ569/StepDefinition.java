package assignmentQ569;

import java.io.FileInputStream;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class StepDefinition {
	
	private List<Integer> numbers;
private int sum;
private int product=1;
	WebDriver driver1;
	@Given("^I open google application$")
	public void OpenUrl() throws Throwable{
		String chromepath = "./Resources/chromedriver";
		System.setProperty("webdriver.chrome.driver", chromepath+".exe");
		ChromeOptions obj_CO = new ChromeOptions();
		obj_CO.addArguments("windos-size=1400,800");
		obj_CO.addArguments("headless");
		WebDriver driver= new ChromeDriver(obj_CO);
		driver.get("https://www.google.co.in");
		
	}
	@Given("^I open my application$")
	public void OpenApp() throws Throwable{
		System.setProperty("webdriver.firefox.marionette","geckodriver.exe");
		 driver1= new FirefoxDriver();
		 driver1.manage().window().maximize();
		driver1.get("https://opensource-demo.orangehrmlive.com/");
		
	}

	@And("^I login with following credentials$")
	public void Login(DataTable dt) throws Throwable{
		List<String> list =dt.asList(String.class);
		System.out.println("Username----" + list.get(0));
		System.out.println("Password----" + list.get(1));
		driver1.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(list.get(0));
		driver1.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(list.get(1));
		driver1.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
	}

	@Then("^Validate Login Success$")
	public void LoginSuccess() throws Throwable{
		driver1.findElement(By.xpath(".//*[@id='welcome']")).isDisplayed();
		
	}
	@And("^Title of page is$")
	public void VerifyTitle(DataTable dt) throws Throwable{
		List<String> list1 =dt.asList(String.class);
		String title =driver1.getTitle();
		Assert.assertTrue(title.equalsIgnoreCase(list1.get(0)));
		System.out.println("Title of the page is: " + title);
		
	}
	@Given("^a list of numbers$")
	public void ListofNumbers(List<Integer> numbers) throws Throwable{
		this.numbers= numbers;
	}
	@When("^I summarize them$")
	public void SumofNumbers() throws Throwable{
		for (int i: numbers){
			sum += i;
		}
	}
	@When("^I Multiply them$")
	public void MultiplicationfNumbers() throws Throwable{
		for (int i: numbers){
			product = product * i;
		}
	}
	@Then("^should I get (\\d+)$")
	public void Verify(int expected) throws Throwable{
		Assert.assertEquals(product, expected);
		System.out.println(product);
		System.out.println(expected);
	}

}
