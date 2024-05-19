package Steps;

import Pages.FirstPage;
import Pages.LoginPage;
import Utils.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AppSteps extends TestContext {

    FirstPage firstPage;
    LoginPage loginPage;
    
    public AppSteps()
    {
        firstPage = new FirstPage(appiumDriver);
        loginPage = new LoginPage(appiumDriver);
    }

    @When("User tap on Main Menu")
    public void userTapOnMainMenu() {
        firstPage.clickOnMainMenu();
    }

    @And("User select Login option")
    public void userSelectLoginOption() {
        firstPage.clickOnLoginMenu();
    }

    @And("User enter {string} as user name")
    public void userEnterUserName(String userEmail) {
        loginPage.enterUserName(userEmail);
    }

    @And("User enter {string} as password")
    public void userEnterPassword(String userPassword) {
        loginPage.enterPassword(userPassword);
    }

    @Then("User verify successful login landed on {string} page")
    public void userVerifySuccessfulLogin(String pageHeader) {
        Assert.assertEquals(pageHeader.toLowerCase(),firstPage.verifyPageHeader().toLowerCase());
    }

    @And("User tap on Login button")
    public void userTapOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Then("User verify the error message displayed for {string}")
    public void userVerifyTheErrorMessageDisplayed(String errorMessage) {
        Assert.assertTrue(loginPage.verifyErrorMessageDisplayed(errorMessage));
    }

}
