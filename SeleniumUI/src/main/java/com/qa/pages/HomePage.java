package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(className = "title")
	WebElement lblProduct;
	
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Backpack')]")
	WebElement lnkProduct;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHeader() {
		return driver.getTitle();
	}
	
	public String getlableText() {
		return lblProduct.getText();
	}
	
	public ItemPage clicksonProduct()
	{
		System.out.println("");
		lnkProduct.click();
		return new ItemPage();
	}
}
