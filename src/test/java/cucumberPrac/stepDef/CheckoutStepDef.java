package cucumberPrac.stepDef;

import cucumberPrac.constants.EndPoint;
import cucumberPrac.context.TestContext;
import cucumberPrac.domainObject.BillingDetails;
import cucumberPrac.pages.CartPage;
import cucumberPrac.pages.CheckOutPage;
import cucumberPrac.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutStepDef {
    private final WebDriver driver;
    private final TestContext context;
    private final CartPage cartPage;
    private final CheckOutPage checkOutPage;
    public CheckoutStepDef(TestContext testContext)
    {
        this.context = testContext;
        driver = testContext.driver;
        cartPage = PageFactoryManager.getCartPage(context.driver);
        checkOutPage = PageFactoryManager.getCheckOutPage(context.driver);
    }

    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
        checkOutPage.load(EndPoint.CHECKOUT.url);
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
         checkOutPage.setBillingDetails(context.billingDetails);
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        checkOutPage.placeOrder();
    }

    @Then("The order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() throws InterruptedException {
        String actualNotice = checkOutPage.getNoticeTxt();
        Assert.assertEquals("Thank you. Your order has been received.",actualNotice);
    }
}
