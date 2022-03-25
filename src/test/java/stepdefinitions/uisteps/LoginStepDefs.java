package stepdefinitions.uisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPageElements;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    CommonPageElements commonPageElements = new CommonPageElements();


    @Given("user is on Medunna Health website")
    public void user_is_on_medunna_health_website() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }

    @Given("user clicks on the login dropdown")
    public void user_clicks_on_the_login_dropdown() {
        loginPage.loginDropdown.click();
    }

    @Given("user clicks on the sign in button")
    public void user_clicks_on_the_sign_in_button() {
        loginPage.signInButton.click();
    }

    @Given("user sends username {string}")
    public void user_sends_username(String string) {
        loginPage.username.sendKeys(string);
    }

    @Given("user sends password {string}")
    public void user_sends_password(String string) {
        loginPage.password.sendKeys(string);
    }

    @Given("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.loginButton.click();
    }

    @Then("verify the login is successful")
    public void verify_the_login_is_successful() {
        Driver.wait(1);
        Assert.assertTrue(commonPageElements.Administration.isDisplayed());
    }

    @Then("close the website")
    public void close_the_website() {
        Driver.closeDriver();
    }

    @Given("verify the option to cancel login")
    public void verify_the_option_to_cancel_login() {
        Assert.assertTrue(loginPage.cancel.isDisplayed());
    }

    @Given("verify the remember me option")
    public void verify_the_remember_me_option() {
        Assert.assertTrue(loginPage.rememberMe.isDisplayed());
    }

    @Given("verify the option Did you forget your password")
    public void verify_the_option_did_you_forget_your_password() {
        Assert.assertTrue(loginPage.forgotPassword.isDisplayed());
    }

    @Given("verify the option Register a new account")
    public void verify_the_option_register_a_new_account() {
        Assert.assertTrue(loginPage.regNewAccount.isDisplayed());
    }

    @Then("user signs out")
    public void user_signs_out() {
        Driver.waitAndClick(commonPageElements.logout);
        Driver.wait(1);
    }



}
