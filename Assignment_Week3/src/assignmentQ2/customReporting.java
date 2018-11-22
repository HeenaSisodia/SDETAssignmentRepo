package assignmentQ2;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class customReporting extends GetSet implements ITestListener {

	static GetSet obj = new GetSet();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Inside Test Pass");
		System.out.println(obj.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Inside Test Failure");
		System.out.println(obj.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Inside Test Skip");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
