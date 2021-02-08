package com.auto.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.auto.pages.LoginPage;
import com.auto.utility.BrowerFactory;
import com.aventstack.extentreports.Status;



public class Login_TC_1 extends TestBase {

	
	@BeforeMethod
	
	public void setupMethod() {
		config.getBrowser();
		config.getURL();
		
		driver=BrowerFactory.StartApplication(driver, config.getBrowser(), config.getURL());		
		logger=extent.createTest("LoginTest");
	}
	
	@Test
	public void loginTest() {
		
		System.out.println("TC1");
		
		//ExcelDataProvider excel= new ExcelDataProvider();
		//excel.getStringData("Login", 0, 0);
		String str =excel.getStringData("Sheet1", 0, 0);
		System.out.println(str);
		//int i=10/0;

		
		logger.log(Status.INFO, "App started : "+config.getURL());
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		logger.log(Status.INFO, "About to login to the portal");
		loginPage.login(excel.getStringData("Sheet1", 0, 0),excel.getStringData("Sheet1", 0, 1));
		logger.log(Status.INFO, "Login sucessfull with user/password : ");	
		
		
		//logger.log(Status.PASS, "Login test sucessful.");

	}
	
	
	

}
