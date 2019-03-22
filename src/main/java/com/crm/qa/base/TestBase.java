package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utilities.TestUtil;
import com.crm.qa.utilities.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\HK-SONY\\Selenium_Eclipse_Workspace\\FreeCRM_NaveenAutomation_POM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void init()
	{
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);		
		driver.get(url);
	}
	
	
}
