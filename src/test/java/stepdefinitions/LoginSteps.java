package stepdefinitions;

import hooks.Hook;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
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

    @When("user input {string} as username")
    public void userInputUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("user input {string} as password")
    public void userInputPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("user click login button")
    public void userClickLoginButton() {
        loginPage.clickLogin();
    }

    @Then("user will see error message {string}")
    public void userWillSeeErrorMessage(String expectedMessage) {
        By errorMessageLocator = By.cssSelector("h3[data-test='error']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String actualMessage = wait
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator))
                .getText();
        System.out.println("Actual error message: " + actualMessage);
        Assert.assertEquals("Error message does not match", expectedMessage, actualMessage);
    }
}
