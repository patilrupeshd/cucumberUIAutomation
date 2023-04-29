package cucumberPrac.stepDef;

import cucumberPrac.constants.Constants;
import cucumberPrac.context.TestContext;
import cucumberPrac.domainObject.BillingDetails;
import cucumberPrac.pages.PageFactoryManager;
import cucumberPrac.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CustomerStepDef {

    private final TestContext context;
    private final StorePage storePage;
    public CustomerStepDef(TestContext context)
    {
        this.context=context;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }
    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        storePage.load(Constants.STORE);
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails=billingDetails;

    }

}
