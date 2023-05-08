package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base{
	public WebDriver driver;
	@Test
	public void testThree() throws Throwable {
		
		System.out.println("Isinde class Three");
		 driver = intilizeDriver();
		driver.get("https://www.google.com/");
		
		driver.close();
	}

}
