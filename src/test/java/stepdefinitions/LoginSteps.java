package stepdefinitions;

import hooks.Hook;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;
    WebDriver driver;

    @Given("user is on the login page")
    public void user_is_on_login_page() {
        driver = Hook.driver;
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @And("user inputs username with {string}")
    public void user_inputs_username(String username) {
        loginPage.enterUsername(username);
    }

    @And("user inputs password with {string}")
    public void user_inputs_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("user clicks the login button")
    public void user_clicks_login_button() {
        loginPage.clickLogin();
    }

    @Then("user should be redirected to the homepage")
    public void user_redirected_to_homepage() {
        Assert.assertTrue("User is not on homepage", loginPage.isOnHomepage());
        driver.quit();
    }

    @Then("user should see an error message {string}")
    public void user_should_see_error_message(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }
}
