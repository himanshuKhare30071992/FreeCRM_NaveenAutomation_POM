package login;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FreeCRM_Registration 
{

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://register.freecrm.com/register/");
		//driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("email")).sendKeys("himanshukhare1992@gmail.com");
		driver.findElement(By.id("phone_number")).sendKeys("9168281259");
		driver.findElement(By.id("terms")).click();
	
		Set<String> it = driver.getWindowHandles();
		System.out.println(it.size());

		List<WebElement> iframe = 	driver.findElements(By.tagName("iframe"));
		System.out.println("iFrame Size ->"+iframe.size());
		
		driver.switchTo().frame(0);
		WebElement checkbox = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-checkmark']"));
		System.out.println(checkbox.isDisplayed());
		System.out.println(checkbox.isEnabled());
		System.out.println(checkbox.isSelected());
		Thread.sleep(2000);	
		checkbox.click();			
		System.out.println(checkbox.isSelected());
		
		
	}
}
