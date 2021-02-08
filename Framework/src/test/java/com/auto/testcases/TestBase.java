package com.auto.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.auto.utility.BrowerFactory;
import com.auto.utility.ConfigDataProvider;
import com.auto.utility.ExcelDataProvider;
import com.auto.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase {
	public static WebDriver driver = null;
	public static ExcelDataProvider excel;
	public static ConfigDataProvider config;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
		excel=new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/extent_result_v3.html");
		extent = new ExtentReports();
	    extent.attachReporter(reporter);
	}
	

	


	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
	
		
		
		if (result.getStatus()== ITestResult.FAILURE) 
		{
			String path =Helper.captureScreensshot(driver);
			
			logger.log(Status.FAIL, "Test Failed.");
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		}
		else
		{
			logger.log(Status.PASS, "Test sucessful.");
		}
		
		
		
		BrowerFactory.closeBrowser(driver);
		
	}
	
	
	@AfterSuite
	public void tearDownSuite() {
		
		extent.flush();
	}
	
	
	
	
}
