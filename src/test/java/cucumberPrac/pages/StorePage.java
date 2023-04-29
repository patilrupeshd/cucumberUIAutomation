package cucumberPrac.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.charset.StandardCharsets;

public class StorePage extends BasePage{
    @FindBy(css = "a[title='View cart']") private WebElement viewCartLink;

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String productName)
    {
        String raw = "a[aria-label='Add “"+productName+"” to your cart']";
        //
        byte[] bytes = raw.getBytes(StandardCharsets.UTF_8);
        String utf8Encoded = new String(bytes,StandardCharsets.UTF_8);
        By addToCart = By.cssSelector(utf8Encoded);
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }
}
