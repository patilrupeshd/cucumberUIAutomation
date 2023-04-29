package cucumberPrac.stepDef;

import cucumberPrac.apis.CartApi;
import cucumberPrac.constants.EndPoint;
import cucumberPrac.context.TestContext;
import cucumberPrac.domainObject.Product;
import cucumberPrac.pages.PageFactoryManager;
import cucumberPrac.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StoreStepDef {
    private final StorePage storePage;
    private TestContext context;
    public StoreStepDef(TestContext context)
    {
        this.context=context;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
        storePage.load(EndPoint.STORE.url);
    }

    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) throws InterruptedException {
        storePage.addToCart(product.getName());
    }
    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() throws InterruptedException {
        //storePage.addToCart("Blue Shoes");
        CartApi cartApi = new CartApi(context.cookies.getCookies());
        cartApi.addCart(1215,3);
        System.out.println("This method getting call ");
        context.cookies.setCookies(cartApi.getCookies());
        context.cookies.injectCookiesToBrowser(context.driver);
    }
}
