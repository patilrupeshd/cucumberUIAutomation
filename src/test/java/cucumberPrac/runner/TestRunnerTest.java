package cucumberPrac.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {"html:target/cucumber/cucumber.html"},
        glue = {"cucumberPrac"},
        features = "src/test/resources/cucumberPrac/features"
)
public class TestRunnerTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }
}
