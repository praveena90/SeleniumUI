package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ItemPage extends TestBase {
	
	@FindBy(className = "inventory_details_name")
	WebElement lblProductName;
	
	public ItemPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getProductName()
	{
		return lblProductName.getText();
	}

}
