package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

import Utilites.ExtentRepter;
import resources.Base;

public class Listneners extends Base implements ITestListener {
public WebDriver driver = null;
ExtentReports extentReport = ExtentRepter.getExtentReprts();
ExtentTest extentTest;
ThreadLocal<ExtentTest> extentThreadTest=new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		String testName= result.getName();
		 extentTest = extentReport.createTest(testName);
		 extentThreadTest.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName= result.getName();
		//extentTest.log(Status.PASS,testName+"Got Passed");
		extentThreadTest.get().log(Status.PASS,testName+"Got Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName= result.getName();
		//extentTest.fail(result.getThrowable());
		
		
		extentThreadTest.get().fail(result.getThrowable());
		
		String testMethodName =result.getName();
		  
	try {
	 driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException |SecurityException  e1) {
		
		e1.printStackTrace();
	}
	
	try {
		String distinationFilePath= takeScreenshot(testMethodName ,driver);
		extentThreadTest.get().addScreenCaptureFromPath(distinationFilePath,testMethodName);
	
	
	}catch(IOException e) {
		e.printStackTrace();
	
	
	}
}
		

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
	
	}
		

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		
	}
	
	

}
