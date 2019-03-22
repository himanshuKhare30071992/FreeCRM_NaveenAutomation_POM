package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class ContactPageTest extends TestBase 
{
	ContactsPage contactsPage;
	LoginPage loginPage;
	HomePage homepage;
	String contactSheetName = "Contacts_TestDataSheet";
	
	
	public ContactPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		init();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homepage =	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickContacts();
	}
	
	
	@Test(priority=1, enabled=false)
	public void verifyContactsPageLabel()
	{
		boolean status = contactsPage.verifyContactsLabel();
		Assert.assertEquals(status, true);
	}
	

	
	//create Object[][] method & call the TestUtil method to get the data from sheet 	
		@DataProvider
		public Object[][] getFreeCRM_TestData()
		{
			Object[][] data =	TestUtil.getTestData(contactSheetName);
			return data;
		}

	
	@Test(priority=2, enabled=true, dataProvider="getFreeCRM_TestData")
	public void newContactsTest(String firstName, String lastName, String day, String	month, String year, String country) throws InterruptedException
	{
		System.out.println("===> "+firstName+lastName+day+month+year+country);
		contactsPage.createnewContact(firstName, lastName, day, month, year, country);
	}
	
	
	@Test(priority=3, enabled=false)
	public void verifyContactTest()
	{
		boolean contactStatus =contactsPage.verifyContact("Himanshu Khare");
		Assert.assertEquals(contactStatus, true, "CONTACT NOT FOUND !!!");
		System.out.println("!!!------------CONTACT FOUND------------!!!");
	}
	
	@Test(priority=4, enabled=false)
	public void deleteContactTest()
	{
		contactsPage.deleteContact("Himanshu Khare");
		contactsPage.deleteContact("Yogesh Sen");
		contactsPage.deleteContact("Pratik Ag");
	}
	
	
	@Test(enabled=false)
	public void editContactTest()
	{
		contactsPage.editContact("Yogesh Sen");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}	
	
	
	
	

	
}
