package gitActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SwagValidTest 
{

		WebDriver driver;
		ChromeOptions options;
		SoftAssert soft;
		
		@BeforeMethod
		public void BrowserSetup() throws InterruptedException
		{
			options=new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu");
			driver = new ChromeDriver(options);
			Thread.sleep(2000);
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
		}

		@Test
		public  void SwagValidLogin() throws InterruptedException
		{   
			
			
			WebElement username=driver.findElement(By.id("user-name"));
			WebElement password=driver.findElement(By.id("password"));
			WebElement login=driver.findElement(By.id("login-button"));
			
			
			username.sendKeys("standard_user");
			Thread.sleep(2000);
			password.sendKeys("secret_sauce");
			Thread.sleep(2000);
			login.click();
			Thread.sleep(3000);
			
		}
		
		@AfterMethod
		public void BrowserTearDown()
		{
			if(driver!=null)
			{
				driver.quit();
			}
		}

}
