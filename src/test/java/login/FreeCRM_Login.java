package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FreeCRM_Login 
{
	
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("email")).sendKeys("himanshukhare1992@gmail.com");
		driver.findElement(By.name("password")).sendKeys("0732540383");
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();	
		
		
	}
	
	

}
