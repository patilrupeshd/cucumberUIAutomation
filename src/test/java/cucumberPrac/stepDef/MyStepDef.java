//package cucumberPrac.stepDef;
//
//import cucumberPrac.constants.Constants;
//import cucumberPrac.constants.EndPoint;
//import cucumberPrac.domainObject.BillingDetails;
//import cucumberPrac.domainObject.Product;
//import cucumberPrac.factory.DriverFactory;
//import cucumberPrac.pages.CartPage;
//import cucumberPrac.pages.CheckOutPage;
//import cucumberPrac.pages.StorePage;
//import cucumberPrac.utils.ConfigLoader;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
////import org.junit.Assert;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//
//import java.util.Optional;
//
//public class MyStepDef {
//    private WebDriver driver;
//    BillingDetails billingDetails;
//
//    @Given("I'm on the Store Page")
//    public void i_m_on_the_store_page() {
//        driver = DriverFactory.getDriver();
//        new StorePage(driver).load(EndPoint.STORE.url);
//    }
//
//    @When("I add a {product} to the cart")
//    public void i_add_a_to_the_cart(Product product) throws InterruptedException {
//        new StorePage(driver).addToCart(product.getName());
//    }
//
//    @Then("I should see {int} {product} in the cart")
//    public void i_should_see_in_the_cart(Integer quantity, Product product) {
//        CartPage cartPage = new CartPage(driver);
//        Assert.assertEquals(product.getName(),cartPage.getProductName());
//        Assert.assertEquals( Optional.of(quantity)
//                , Optional.of(cartPage.getProductQuantity()));
//    }
//
//    @Given("I'm a guest customer")
//    public void iMAGuestCustomer() {
//        driver = DriverFactory.getDriver();
//        new StorePage(driver).load(Constants.STORE);
//    }
//
//    @And("my billing details are")
//    public void myBillingDetailsAre(BillingDetails billingDetails) {
//        this.billingDetails=billingDetails;
//
//    }
//
//    @And("I have a product in the cart")
//    public void iHaveAProductInTheCart() throws InterruptedException {
//        new StorePage(driver).addToCart("Blue Shoes");
//    }
//
//    @And("I'm on the Checkout page")
//    public void iMOnTheCheckoutPage() {
//        new CartPage(driver).checkOut();
//    }
//
//    @When("I provide billing details")
//    public void iProvideBillingDetails() {
//        CheckOutPage checkOutPage = new CheckOutPage(driver);
//        checkOutPage.setBillingDetails(billingDetails);
//    }
//
//    @And("I place an order")
//    public void iPlaceAnOrder() {
//       new CheckOutPage(driver).placeOrder();
//    }
//
//    @Then("The order should be placed successfully")
//    public void theOrderShouldBePlacedSuccessfully() throws InterruptedException {
//        String actualNotice = new CheckOutPage(driver).getNoticeTxt();
//        Assert.assertEquals("Thank you. Your order has been received.",actualNotice);
//    }
//}
