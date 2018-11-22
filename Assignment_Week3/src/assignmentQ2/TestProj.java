package assignmentQ2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

@Listeners(customReporting.class)
public class TestProj {
	
	
	@Test(priority=1)
	public void Test1(){
		System.out.println("Inside Test1");
		customReporting.obj.setName("Test1Class");
	}
	
	@Test (priority=2)
	public void Test2(){
		System.out.println("Inside Test2");
		customReporting.obj.setName("Test2Class");
		Assert.fail();
	}
	
	@Test (priority=3, dependsOnMethods = {"Test2"})
	public void Test3(){
		System.out.println("Inside Test3");
	}

}
