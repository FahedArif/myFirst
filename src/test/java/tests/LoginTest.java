package tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;

import pageobjects.AccountPage;
import pageobjects.LadingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	Logger log;
	 public WebDriver driver;
	@BeforeMethod
	public void openApplication() throws Throwable {
		log = LogManager.getLogger(LoginTest.class.getName());

		driver = intilizeDriver();
		log.debug("Browser got lunched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigateed to application url");
	}

	@Test(dataProvider = "getLoginData")
	public void login(String email, String password, String expectedResult) throws Throwable {

		LadingPage lodingpage = new LadingPage(driver);
		lodingpage.myAccountDropdown().click();
		log.debug("Clicked on my account Dropdown");
		lodingpage.loginOption().click();
		log.debug("Clicked on login page");
		//Thread.sleep(3000);

		LoginPage loginpage = new LoginPage(driver);
		loginpage.emailAdressFeild().sendKeys(email);
		log.debug("email adress got enter");
		loginpage.passwordAdressFeild().sendKeys(password);
		log.debug(" passwor got entered");
		loginpage.loginbtn().click();
		log.debug("clicked on login button");

		AccountPage accountpageoption = new AccountPage(driver);

		String actuaResult = null;
		try {
			if (accountpageoption.editAccountInfoOption().isDisplayed()) {
				log.debug("user got login");
				actuaResult = "Sucessfull";
			}

		} catch (Exception e) {
			log.debug("user didnt login");
			actuaResult = "Failure";
			log.info(actuaResult);

		}
		//if (actuaResult.equals(expectedResult)) {
			//log.info("user got logged in");
		//} else {
			//log.info("loggin got failed");
		//}
		assertEquals(actuaResult, expectedResult);
		log.debug("Login test got passed");

	}

	

	@AfterMethod
	public void clouser() {
		driver.close();
		log.debug("Browswer got clossed");
	}

	@DataProvider
	public Object[][] getLoginData() {

		Object[][] data = { { "arif@gmail.com", "Arif123", "Sucessfull" },
				{ "fahed@gmail.com", "fjsdhjhf", "Failure" } };
		return data;
	}
}
