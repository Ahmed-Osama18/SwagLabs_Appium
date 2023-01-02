package tests;

import actions.MobileActions;
import com.shaft.tools.io.JSONFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class CartTest {

    // preconditions
    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver = new Common().setCapabilities();
        data = new JSONFileManager("src/test/resources/TestDataFiles/Data.json");
        new MobileActions(driver);

        // login using correct credentials as a pre-condition
        new LoginPage(driver)
                .enterUsername(data.getTestData("username"))
                .enterPassword(data.getTestData("password"))
                .clickLogin();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }

    //////////////////////////////// Tests \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    // add any item to the cart and validate if that Title and price of the Item at Home page equals the item and price at the cart.
    @Test
    public void validateAddedItems() throws IOException {
        //store the item price from product page
        String PriceInProductPage = new ProductsPage(driver).getItemPrice_InProductPage();
        //store the item title from product page
        String TitleInProductPage = new ProductsPage(driver).getItemTitle_InProductPage();

        //store the item title from cart page
        String TitleInCartPage = new ProductsPage(driver)
                .addBackPackItemToCart()
                .openCart()
                .getItemTitle_InCartPage();
        //store the item price from cart page
        String PriceInCartPage = new CartPage(driver).getItemPrice_InCartPage();

        //validate that the price in cart page is the same price in product page
        Assert.assertEquals(TitleInCartPage, TitleInProductPage);
        //validate that the title in cart page is the same title in product page
        Assert.assertEquals(PriceInCartPage, PriceInProductPage);

        // capture screenshot to project folder.
        new Common().captureScreenshot(driver,"CartTest","validateAddedItems");
    }

    // validate removing items from the cart and validate that the cart is empty.
    @Test
    public void validateRemovedItems() throws IOException {
        // add item to cart and remove it to validate that items removed successfully.
        new ProductsPage(driver)
                .addBackPackItemToCart()
                .openCart()
                .removeItemFromCart()
                //validate that cart logo does not contain any number after removing items.
                .validateCartQuantityIsEmpty()
                //validate that cart page is empty after removing items.
                .validateRemovedItemFromCart();

        // capture screenshot to project folder.
        new Common().captureScreenshot(driver,"CartTest","validateRemovedItems");
    }

    // (End-to-end) complete the flow from adding element to cart till the checkout, and validate the price and success purchase.
    @Test
    public void validateCheckout() throws IOException {
        new ProductsPage(driver)
                .addBackPackItemToCart()
                .openCart()
                .clickOnCheckout()
                .enterFirstname(data.getTestData("firstname"))
                .enterLastname(data.getTestData("lastname"))
                .enterPostalCode(data.getTestData("zipCode"))
                .clickOnContinue();

        //validate that the purchsed item cost is the same in checkout page before compelete the purchse.
        Assert.assertEquals(new CheckoutOverviewPage(driver).getPriceInOverviewPage(),"$29.99");

        //scroll down to be able to click on finish button.
        MobileActions.scrollDownToSpecificText("FINISH");
        new CheckoutOverviewPage(driver)
                .clickOnFinish()
                //validate that purchsed compeleted successfully by (Thank you message).
                .validateSuccessPurchase(data.getTestData("success_msg"));

        // capture screenshot to project folder.
        new Common().captureScreenshot(driver,"CartTest","validateCheckout");
    }
    @AfterMethod
    public void captureAndQuitDriver()
    {
        // capture screenshot to allure report.
        new Common().allureCaptureScreenshot(driver);

        // quit the driver in case it is open.
        if (driver != null) {
            driver.quit();
        }
    }

    ///////////////////////////// variables \\\\\\\\\\\\\\\\\\\\\\\\\
    // driver and file manager
    private WebDriver driver;
    private JSONFileManager data;
}
