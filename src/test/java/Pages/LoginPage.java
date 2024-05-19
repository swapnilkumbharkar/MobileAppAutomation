package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage
{
    AppiumDriver appiumDriver;
    WebDriverWait wait;
    @AndroidFindBy(accessibility = "Username input field")
    WebElement userNameInput;
    @AndroidFindBy(accessibility = "Password input field")
    WebElement passwordInput;
    @AndroidFindBy(accessibility = "Login button")
    WebElement loginButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='generic-error-message']/android.widget.TextView")
    WebElement lockedErrorMessage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Provided credentials do not match any user in this service.']")
    WebElement noMatchErrorMessage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Username is required']")
    WebElement noUserDetailsErrorMessage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Password is required']")
    WebElement noPasswordErrorMessage;
    public LoginPage(AppiumDriver appiumDriver)
    {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void enterUserName(String userEmail)
    {
        userNameInput.sendKeys(userEmail);
    }

    public void enterPassword(String password)
    {
        passwordInput.sendKeys(password);
    }

    public void clickOnLoginButton()
    {
        loginButton.click();
    }

    public boolean verifyErrorMessageDisplayed(String errorMessage)
    {
        return switch (errorMessage) {
            case "LOCKED" -> lockedErrorMessage.isDisplayed();
            case "NO MATCH" -> noMatchErrorMessage.isDisplayed();
            case "NO USER DETAILS" -> noUserDetailsErrorMessage.isDisplayed();
            case "NO PASSWORD" -> noPasswordErrorMessage.isDisplayed();
            case null, default -> false;
        };

    }
}
