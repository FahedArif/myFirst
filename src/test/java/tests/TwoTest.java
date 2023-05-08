package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



import resources.Base;

public class TwoTest extends Base {
	public WebDriver driver;
	@Test
	public void testTwo() throws Throwable  {
		
		System.out.println("Isinde class Two");
		
		 driver = intilizeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		
		Thread.sleep(2000);
		
		Assert.assertTrue(false);
		
		
		
	}
	@AfterMethod
	public void closigBrowser() {
		driver.close();
		}

}
