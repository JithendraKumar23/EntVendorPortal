package Generics;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import Constant.BaseTest;

public class Listeners extends BaseTest implements ITestListener {


	public void onTestStart(ITestResult result) 
	{
		System.out.println("\n\n"+result.getName() + " Test Case Started " );
	}

	public void onTestSuccess(ITestResult result) 
	{
		System.out.println(result.getName() + " Test Case Success ");
		test=report.startTest(result.getName());
		test.log(LogStatus.PASS, result.getName() + " Test Case Success ");
	}

	public void onTestFailure(ITestResult result) 
	{
		System.out.println(result.getName() + " Test Case Failed ");
		test=report.startTest(result.getName());
		test.log(LogStatus.FAIL, result.getName() + " Test Case Failed ");
	}

	public void onTestSkipped(ITestResult result) 
	{
		System.out.println(result.getName() + " Test Case Failed ");
		test=report.startTest(result.getName());
		test.log(LogStatus.SKIP, result.getName() + " Test Case Failed ");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		@SuppressWarnings("static-access")
		float percentage = result.SUCCESS_PERCENTAGE_FAILURE;
		System.out.println(result.getName() + " test cases failed, success percentage is :" + percentage);
		System.out.println("onTestFailedButWithinSuccessPercentage for "+ result.getMethod().getMethodName());
	}

	public void onStart(ITestContext context) 
	{

	}

	public void onFinish(ITestContext context) 
	{

	}



}
