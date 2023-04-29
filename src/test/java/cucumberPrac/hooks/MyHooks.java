package cucumberPrac.hooks;

import cucumberPrac.context.TestContext;
import cucumberPrac.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class MyHooks {
    private WebDriver driver;
    private final TestContext testContext;

    public MyHooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void before(Scenario scenario)
    {
       // System.out.println("BEFORE THREAD ID : " + Thread.currentThread().getId());
       // System.out.println("BEFORE SCENARIO : " + scenario.getName());
        String browserName = System.getProperty("browser","chrome");
        driver = DriverFactory.initializeDriver(browserName);
        testContext.driver=driver;
    }

    @After
    public void after(Scenario scenario)
    {
        System.out.println("AFTER THREAD ID : " + Thread.currentThread().getId());
        System.out.println("AFTER SCENARIO : " + scenario.getName());

        driver.quit();
    }
}
