package com.qa.tests;

import java.lang.reflect.Method;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");
	
		Logger log = Logger.getLogger(getClass());
	//Sheet name of the excel data doc
	private String sheetName = "credentails";
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod()
	public void setUp() {
		init();
		loginPage = new LoginPage();
	}
	
	@BeforeMethod()
	public void afterMethod(Method method) {
	  System.out.println("<------------------ Method Name:" + method.getName()+" ------------------->");
	}

	@Test()
	public void loginTitleTest() {
		loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPage.validateLoginPageTitle(), "Swag Labs");
	}
	
	@Test(priority = 2)
		public  void loginTest()
	{
		log.info("Stating the test");
		homePage = loginPage.login(username, password);
	}
	
	
	//Get the data from the execl sheet using TestUtil class
	@DataProvider
	public Object[][] getTestData() throws InvalidFormatException {
		Object object[][]=TestUtil.getTestData(sheetName);
		return object;
	}
	
	//Using the data provider to run the test
	@Test(dataProvider = "getTestData")
	public void multipleLogin(String username,String password)
	{
		homePage = loginPage.login(username, password);
	}

}
