package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//span[text()='Himanshu Khare']")
	WebElement usernameLabel;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[text()='Tasks']")
	WebElement tasksLink;
	
	
	
// All these 4 elements will be initialized 	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage clickContacts()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	
	public DealsPage clickDeals()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	
	public TasksPage clickTasks()
	{
		contactsLink.click();
		return new TasksPage();
	}
	
	public boolean verifyCorrectUsernameLabel()
	{
		return usernameLabel.isDisplayed();
	}
		
}
