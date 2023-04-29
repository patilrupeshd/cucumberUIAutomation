package cucumberPrac.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
    public static WebDriver initializeDriver(String browser)
    {
        WebDriver driver;
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\T450\\git\\cucumberUIAutomation\\chromedriver.exe");
                driver = new
                        ChromeDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                System.setProperty("webdriver.edge.driver", "C:\\Users\\T450\\git\\cucumberUIAutomation\\msedgedriver.exe");
                driver = new EdgeDriver();
            }
            default -> throw new IllegalStateException("INVALID BROWSER : " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }

}
