package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase 
{
	LoginPage lp;
	HomePage homepage;
	
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		init();
		lp = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
	@Test(priority=1)
	public void validateLoginPageTitle()
	{
		String title = lp.validateLoginPageTitle();
		System.out.println("===Login Page Title=== "+title);
		Assert.assertEquals(title, "Cogmento CRM");
		System.out.println("----validateLoginPageTitle:-  Assertion Passed----");
	}
	
	
	@Test(priority=2)
	public void crmbellIcon()
	{
		boolean status = lp.validatebellIcon();
		Assert.assertEquals(status, true);
		System.out.println("----crmbellIcon:-  Assertion Passed----");
	}

	
	@Test(priority=3)
	public void loginTest() throws InterruptedException
	{
		homepage = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	
	
}
