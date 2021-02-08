package com.auto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	@FindBy(how=How.XPATH, using="//input[@id='usernameField']")
	@CacheLookup
	WebElement userName;
	
	@FindBy(how=How.XPATH, using="//input[@id='passwordField']")
	@CacheLookup
	WebElement passWord;
	
	@FindBy(how=How.XPATH, using="//button[text()='Login']")
	@CacheLookup
	WebElement loginButton;
	
	
	public void login(String userNm, String passWd) {

		userName.sendKeys(userNm);
		passWord.sendKeys(passWd);
		loginButton.click();
		
	}
	
	

}
