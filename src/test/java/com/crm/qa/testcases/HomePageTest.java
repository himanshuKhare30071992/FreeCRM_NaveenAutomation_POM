package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase 
{	
	LoginPage lp;
	HomePage homepage;
	ContactsPage contactpage;
	
	HomePageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		init();
		lp = new LoginPage();
		contactpage = new ContactsPage();
		homepage = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String title = homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM", "---ASSERTION FAILED---");
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		boolean status =homepage.verifyCorrectUsernameLabel();
		Assert.assertTrue(status); 
	}
	
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		contactpage = 	homepage.clickContacts();
	}
	

	
}
