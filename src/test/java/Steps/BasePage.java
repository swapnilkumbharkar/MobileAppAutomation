package Steps;

import Utils.AppUtil;
import Utils.TestContext;
import io.cucumber.java.*;

import java.io.IOException;

public class BasePage extends TestContext
{
    @Before("@app")
    public void beforeScenario(Scenario scenario)
    {
        appiumDriver = AppUtil.openApp();
    }

    @After("@app")
    public void afterScenario(Scenario scenario)
    {
        AppUtil.closeApp();
    }

    @AfterStep("@app")
    public void takeScreenshot(Scenario scenario) throws IOException {
        scenario.attach(AppUtil.screenshot(), "image/png", "Screenshot");
    }

}
