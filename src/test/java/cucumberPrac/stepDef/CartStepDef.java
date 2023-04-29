package cucumberPrac.stepDef;

import cucumberPrac.context.TestContext;
import cucumberPrac.domainObject.Product;
import cucumberPrac.pages.CartPage;
import cucumberPrac.pages.PageFactoryManager;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.Optional;

public class CartStepDef {
    private final CartPage cartPage;
    public CartStepDef(TestContext testContext)
    {
        cartPage = PageFactoryManager.getCartPage(testContext.driver);
    }

    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(Integer quantity, Product product) {
        Assert.assertEquals(product.getName(),cartPage.getProductName());
        Assert.assertEquals( Optional.of(quantity)
                , Optional.of(cartPage.getProductQuantity()));
    }
}
