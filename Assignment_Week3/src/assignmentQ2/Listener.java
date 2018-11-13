package assignmentQ2;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
/* ------- this is the listener class which prints pass and fail for test methods in 
Implementing listener class -----------------*/

public class Listener implements ITestListener {
	public String status;
	
	@Override
	public void onStart(ITestContext context) {
		Reporter.log("Execution Starts " + context.getName(), true);
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("Execution Starts for the test: " + result.getTestName(), true);
		//System.out.println("Execution Starts for the test: " + result.getTestName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			status= "PASS";
		}
	
		Reporter.log ("Test Result: "+ status, true);
		
			}

	@Override
	public void onTestFailure(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS_PERCENTAGE_FAILURE)
		{
			status= "FAILED";
		}
		if(result.getStatus() == ITestResult.FAILURE)
		{
			status= "FAILED";
		}
	
		Reporter.log ("Test Result: "+ status);

		
	}
		

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test Skipped:  " + result.getTestName(), true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("Execution Ends " + context.getName(), true);
		
	}

}

