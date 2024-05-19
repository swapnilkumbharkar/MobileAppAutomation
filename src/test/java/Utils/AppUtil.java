package Utils;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import static io.cucumber.core.exception.ExceptionUtils.printStackTrace;

public class AppUtil extends TestContext
{
    public static AppiumDriver openApp () {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();

                capabilities.setCapability("deviceName", ConfigUtil.getValue("deviceName"));
                capabilities.setCapability("udid", ConfigUtil.getValue("udid"));
                capabilities.setCapability("platformName", ConfigUtil.getValue("platformName"));
                capabilities.setCapability("platformVersion", ConfigUtil.getValue("platformVersion"));
                capabilities.setCapability("automationName", ConfigUtil.getValue("automationName"));
                capabilities.setCapability("app", new File(ConfigUtil.getValue("app")).getAbsolutePath());

//                If you have application already installed the below 2 capabilities can be used instead of 'app'
//                capabilities.setCapability("appPackage", ConfigUtil.getValue("appPackage"));
//                capabilities.setCapability("appActivity", ConfigUtil.getValue("appActivity"));


            URL url = new URI("http://127.0.0.1:4723").toURL();

            appiumDriver = new AppiumDriver(url, capabilities);
            appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        catch (Exception e)
        {
            System.out.println("Driver Initialisation failed-".concat(printStackTrace(e)));
        }
        return appiumDriver;
    }

    public static byte[] screenshot() throws IOException {
        File srcFile = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
        FileInputStream fis = new FileInputStream(srcFile);
        byte[] screenshotBytes = fis.readAllBytes();
        fis.close();
        return screenshotBytes;
    }

    public static void closeApp()
    {
        appiumDriver.quit();
    }


}
