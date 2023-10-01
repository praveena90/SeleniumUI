package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id = "user-name")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "login-button")
	WebElement btnLogin;
	
	@FindBy(xpath = "//div[contains(text(),'Swag Labs')]")
	WebElement logo;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String uname,String pw) {
		username.sendKeys(uname);
		password.sendKeys(pw);
		btnLogin.click();
		
		return new HomePage();
	}
	

	
	
}
