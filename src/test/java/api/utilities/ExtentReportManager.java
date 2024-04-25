package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 String destination = System.getProperty("user.dir") + "/Screenshots/"+dateName+".html";
		
		
		htmlReporter= new ExtentSparkReporter(destination);
		reports= new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//set Environment details
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("username", "Kiran");
		reports.setSystemInfo("Machine", "Lenovo");
		reports.setSystemInfo("OS", "Windows10");
		
		//look and feel of report
		
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		
		
	}	
	public void onStart(ITestContext result)
	{
		configureReport();
		System.out.println("On Start Method Invoked...");
		
	}
	
	public void onFinish(ITestContext result)
	{
		System.out.println("On Finish Method Invoked...");
		reports.flush();
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Failed Method Name"+ result.getName());
	   test=reports.createTest(result.getName());
	   test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case" + result.getName(), ExtentColor.RED));
	}
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("Name of Statrted Method"+ result.getName());
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Success Method Name"+ result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the success testcase"+ result.getName(), ExtentColor.GREEN));
	}
	
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Skipped Method Name"+ result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skipped testcase" + result.getName(), ExtentColor.YELLOW));
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		System.out.println("On Test failed but with percentage Method Name"+ result.getName());
		
	}

}
