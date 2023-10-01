package com.qa.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.ItemPage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ItemPage itemPage;
	
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		homePage= loginPage.login(username, password);
	}
	
//	@Test
//	public void verifyHomePageTitle() {
//		String title = homePage.getHeader();
//		assertEquals("Swag Labs", title);
//	}
//	
	@Test(priority = 0)
	public void navigateToProduct() {
		itemPage = homePage.clicksonProduct();
		String productName = itemPage.getProductName();
		Assert.assertEquals(productName, "Sauce Labs Backpack");
	} 

}
