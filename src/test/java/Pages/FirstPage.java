package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstPage
{
    AppiumDriver appiumDriver;
    WebDriverWait wait;
    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView")
    WebElement mainMenu;
    @AndroidFindBy(accessibility="menu item log in")
    WebElement loginMenu;
    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='container header']/android.widget.TextView")
    WebElement getPageHeader;

    public FirstPage(AppiumDriver appiumDriver)
    {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void clickOnMainMenu()
    {
        mainMenu.click();
    }

    public void clickOnLoginMenu()
    {
        loginMenu.click();
    }

    public String verifyPageHeader()
    {
        return getPageHeader.getText();
    }

    public void verifyAppStarted()
    {

    }
}
