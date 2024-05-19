package Utils;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = {"pretty", "json:test-output/Cucumber.json","html:STDOUT","html:test-output/Cucumber.html"},
        features = {"src/test/java/Features"},
        glue = {"Steps"},
        tags = "@app"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    public TestRunner() {

    }
}


