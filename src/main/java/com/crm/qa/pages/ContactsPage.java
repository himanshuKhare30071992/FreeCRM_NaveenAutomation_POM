package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;
import com.crm.qa.utilities.TestUtil;


public class ContactsPage extends TestBase 
{
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']") ////div[contains(text(),'Contacts')]
	@CacheLookup
	WebElement contactLabel;
	
	@FindBy(xpath="//a[contains(@href,'/contacts/new')]")
	@CacheLookup
	WebElement newContact;
	 
	@FindBy(name="first_name")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(name="last_name")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	@CacheLookup
	WebElement saveButton;
	
	@FindBy(xpath="//span[text()='Contacts']")
	@CacheLookup
	WebElement contactLink;
	
	@FindBy(xpath="//button[@class='ui small fluid positive toggle button']")
	@CacheLookup
	WebElement access; 
	
	@FindBy(xpath="//div[@name='channel_type']")
	@CacheLookup
	WebElement contactSocialChannelType;
	
	@FindBy(xpath="//div[@class='visible menu transition']//div//span[text()='Facebook']")
	@CacheLookup
	WebElement contactFacebookLink;
	
	@FindBy(xpath="//div[@name='timezone']")
	@CacheLookup
	WebElement contactTimeZone;
	
	WebElement contactCountry;
	
	@FindBy(xpath="//div[@class='four fields']//div[@class='ui search selection dropdown']")
	@CacheLookup
	WebElement contactPhone;

	WebElement contactStatus;
	WebElement contactSource;
	WebElement contactCategory;
	
	@FindBy(xpath="//div[@class='ui toggle checkbox']//input[@name='do_not_call']")
	WebElement contactDoNotCall;
	
	WebElement contactDoNotText;
	WebElement contactDoNotEmail;
	
	@FindBy(xpath="//input[@name='day']")
	@CacheLookup
	WebElement contactDay;

	@FindBy(xpath="//div[@name='month']//i")
	@CacheLookup
	WebElement contactMonth;

	@FindBy(xpath="//input[@name='year']")
	@CacheLookup
	WebElement contactYear;
	
	
	@FindBy(xpath="//input[@type='file']")
	WebElement contactImage;
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel()
	{
		return contactLabel.isDisplayed();
	}
	
	
	public void createnewContact(String fname, String lname, String day, String month, String year, String countryName) throws InterruptedException
	{
		
		System.out.println("createnewContact  with data --> "+fname+lname+day+month+year+countryName);
				
		TestUtil.flashElement(newContact);
		newContact.click();
		
	
		TestUtil.flashElement(firstName);
		firstName.sendKeys(fname);
		
		
		TestUtil.flashElement(lastName);
		lastName.sendKeys(lname);
		
		
		TestUtil.flashElement(access);
		access.click();
	
		
		TestUtil.flashElement(contactSocialChannelType);
		contactSocialChannelType.click();
		
		TestUtil.flashElement(contactFacebookLink);
		contactFacebookLink.click();
			
//		contactTimeZone.click();
//		driver.findElement(By.xpath("//div[@name='timezone']//input")).sendKeys("Indian/Mahe");
//		TestUtil.clickElementByAction(contactTimeZone);
		
		
		TestUtil.scrollDown(500);
		
		TestUtil.flashElement(contactPhone);
		TestUtil.clickElementByAction(contactPhone);
		driver.findElement(By.xpath("//div[@class='visible menu transition']//div//span[text()='"+countryName+"']")).click();
		
		
		TestUtil.flashElement(contactDoNotCall);
		TestUtil.clickElementByAction(contactDoNotCall);
		
		
		TestUtil.flashElement(contactDay);
		contactDay.sendKeys(day);

		
		TestUtil.flashElement(contactMonth);
		contactMonth.click();
		
		
		List <WebElement> listOfmonths = driver.findElements(By.xpath("//div[@class='visible menu transition']//div//span")); 
		int monthList = listOfmonths.size();
		System.out.println("Number of Months List => "+monthList);
		
		for (int i = 1; i <= monthList; i++) 
		{
			System.out.println(listOfmonths.get(i).getText());
			if(listOfmonths.get(i).getText().contains(month))
			{
				listOfmonths.get(i).click();
				break;
			}
		}
		
		TestUtil.flashElement(contactYear);
		contactYear.sendKeys(year);

		TestUtil.scrollDown(1000);
		
		TestUtil.flashElement(contactImage);
		contactImage.sendKeys("C:\\Users\\HK-SONY\\Desktop\\Capture.PNG");

		TestUtil.flashElement(saveButton);
		saveButton.click();
			
	}

	
	
	public boolean verifyContact(String contactName)
	{
		newContact.click();
		return driver.findElement(By.xpath("//td[text()='"+contactName+"']")).isDisplayed();
	}
	
	
	public void deleteContact(String contactName)
	{
		driver.findElement(By.xpath("//td[text()='"+contactName+"']")).click();
		driver.findElement(By.xpath("//td[text()='"+contactName+"']//following::td[4]//div//button")).click();
		//driver.findElement(By.xpath("//button[@class='ui button']")).click();
	}
	
	
	public void editContact(String contactName)
	{
		driver.findElement(By.xpath("//td[text()='"+contactName+"']")).click();
		driver.findElement(By.xpath("//td[text()='"+contactName+"']//following::td[4]//a[2]//button")).click();
	}
}
