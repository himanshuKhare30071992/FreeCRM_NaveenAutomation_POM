package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.utilities.TestUtil;


public class LoginPage extends TestBase 
{
	// Page Factory - Object Repository 
	
	@FindBy(name="email")
	WebElement userEmail;
	
	@FindBy(name="password")
	WebElement userPassword;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@class='onesignal-bell-launcher-button']")
	WebElement bellIcon;
	
	
	
//Initializing the Page Objects(OR)
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validatebellIcon()
	{
		return bellIcon.isDisplayed();
	}
	
//Actions which needs to be performed on LoginPage	
	
	public HomePage login(String email, String pwd) throws InterruptedException
	{
		TestUtil.flashElement(userEmail);
		userEmail.sendKeys(email);
		
		TestUtil.flashElement(userPassword);
		userPassword.sendKeys(pwd);
		
		TestUtil.flashElement(loginButton);
		loginButton.click();
		
		return new HomePage();
	}
}