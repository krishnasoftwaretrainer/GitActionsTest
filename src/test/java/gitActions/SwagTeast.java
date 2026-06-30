package gitActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SwagTeast 
{
	WebDriver driver;
	ChromeOptions options;
	SoftAssert soft;
	
	@BeforeMethod
	public void BrowserSetup() throws InterruptedException
	{
		options=new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void tittleVerification()
	{
	String expectedURL="https://www.saucedemo.com/";
	String actualURL=driver.getCurrentUrl();
	
	soft = new SoftAssert();
	soft.assertEquals(actualURL, expectedURL, "URL is incorrect");
	System.out.println("Success");
	soft.assertAll();

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
