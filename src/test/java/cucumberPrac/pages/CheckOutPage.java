package cucumberPrac.pages;

import cucumberPrac.domainObject.BillingDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage{


    @FindBy(id = "billing_first_name") private WebElement firstNameFld;
    @FindBy(id = "billing_last_name") private WebElement lastNameFld;
    @FindBy(id = "billing_address_1") private WebElement billingAddressOneFld;
    @FindBy(id = "billing_city") private WebElement billingCityFld;
    @FindBy(id = "billing_state") private WebElement billingStateDropDown;
    @FindBy(id = "billing_postcode") private WebElement billingZipFld;
    @FindBy(id = "billing_email") private WebElement billingEmailFld;
    @FindBy(id = "place_order") private WebElement placeOrder;
    @FindBy(css = ".woocommerce-notice") private WebElement noticeTxt;

    //Dropdown issues for Firefox and how to resolved this
    @FindBy(id = "select2-billing_state-container") private WebElement billingState_Alternate_DropDown;

    //TO handel overlay
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }


    public CheckOutPage enterBillingZip(String billingZip)
    {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingZipFld));
        e.clear();
        e.sendKeys(billingZip);
        return this;
    }

    public CheckOutPage enterBillingEmail(String billingEmail)
    {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmailFld));
        e.clear();
        e.sendKeys(billingEmail);
        return this;
    }

    public CheckOutPage selectBillingState(String billingState)
    {
        //This solution is for Firefox browser
        wait.until(ExpectedConditions.elementToBeClickable(billingState_Alternate_DropDown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+billingState+"']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",e);
        e.click();

        //Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingStateDropDown)));
        //select.selectByVisibleText(billingState);
        return this;
    }

    public CheckOutPage enterBillingAddressOne(String billingAddressOne)
    {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddressOneFld));
        e.clear();
        e.sendKeys(billingAddressOne);
        return this;
    }

    public CheckOutPage enterBillingCity(String billingCity)
    {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCityFld));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }

    public CheckOutPage enterBillingFirstName(String billingFirstName)
    {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(firstNameFld));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;
    }
    
    public CheckOutPage enterBillingLastName(String billingLastName)
    {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(lastNameFld));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }


    public CheckOutPage setBillingDetails(BillingDetails billingDetails)
    {
        return enterBillingFirstName(billingDetails.getBillingFirstName())
                .enterBillingLastName(billingDetails.getBillingLastName())
                .enterBillingAddressOne(billingDetails.getBillingAddressOne())
                .enterBillingCity(billingDetails.getBillingCity())
                .selectBillingState(billingDetails.getBillingStateName())
                .enterBillingZip(billingDetails.getBillingZip())
                .enterBillingEmail(billingDetails.getBillingEmail());
    }

    public CheckOutPage placeOrder()
    {
        waitForOverlayToDisappear(overlay);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder)).click();
        return this;
    }

    public String getNoticeTxt()
    {
        return wait.until(ExpectedConditions.visibilityOf(noticeTxt)).getText();
    }


}
