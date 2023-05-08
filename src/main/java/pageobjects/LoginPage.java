package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "email")
	private WebElement emailAdressFeild;

	@FindBy(name = "password")
	private WebElement passwordAdressFeild;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginbtn;

	public WebElement emailAdressFeild() {
		return emailAdressFeild;
	}

	public WebElement passwordAdressFeild() {
		return passwordAdressFeild;

	}

	public WebElement loginbtn() {
		return loginbtn;
	}

}
