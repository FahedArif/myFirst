package stepDiffination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.LadingPage;
import pageobjects.LoginPage;
import resources.Base;

public class Login extends Base {

       WebDriver driver;
       LadingPage lodingpage;
       LoginPage loginPage;
       AccountPage accountpageoption;
       
    @Given("^open my Browsre$")
    public void open_my_browsre() throws Throwable  {
    	driver= intilizeDriver();        
    }
    @And("^Navigate to Login page$")
    public void navigate_to_login_page() throws InterruptedException  {
    	driver.get(prop.getProperty("url"));

		 lodingpage = new LadingPage(driver);
		lodingpage.myAccountDropdown().click();
		lodingpage.loginOption().click();
		Thread.sleep(3000);
    }

    @When("^user enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the feilds$")
    public void user_enters_username_as_something_and_password_as_something_into_the_feilds(String email, String password)  {
    	LoginPage loginpage = new LoginPage(driver);
		loginpage.emailAdressFeild().sendKeys(email);
		loginpage.passwordAdressFeild().sendKeys(password);
		
    }
    @And("^user click on login button$")
    public void user_click_on_login_button() throws Throwable {
    	loginPage.loginbtn().click();
      
    }

    @Then("^verify user is able to successfully login$")
    public void verify_user_is_able_to_successfully_login() {
    	accountpageoption = new AccountPage(driver);
    	Assert.assertTrue(accountpageoption.editAccountInfoOption().isDisplayed());
    	
     }
    @After
    public void ClouserBrowser() {
    	driver.close();
    	
    }

  

   

}
