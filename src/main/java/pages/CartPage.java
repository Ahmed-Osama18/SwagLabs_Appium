package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage {

    /////////////////////////// constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    /////////////////////////// actions
    public String getItemTitle_InCartPage()  {
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(CART_ITEM_TITLE)));
        return driver.findElement(CART_ITEM_TITLE).getText();
    }

    public String getItemPrice_InCartPage() {
        return driver.findElement(CART_ITEM_PRICE).getText();
    }

    public CartPage removeItemFromCart(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(REMOVE_BTN));
        driver.findElement(REMOVE_BTN).click();
        return this;
    }

    public String getCartIconQuantity() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(CART_ICON_QTY));
        return driver.findElement(CART_ICON_QTY).getText();
    }

    public CartPage validateRemovedItemFromCart()  {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(CART_ITEM_TITLE));
        Assert.assertTrue(true);
        return this;
    }

    public CartPage validateCartQuantityIsEmpty() {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(CART_ICON_QTY));
        Assert.assertTrue(true);
        return this;
    }
    public CheckoutInformationPage clickOnCheckout()
    {
        driver.findElement(CHECKOUT_BTN).click();
        return new CheckoutInformationPage(driver);
    }

    //////////////////////// driver and locators
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    private By CART_ITEM_TITLE = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
    private By CART_ITEM_PRICE = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");
    private By REMOVE_BTN = AppiumBy.accessibilityId("test-REMOVE");
    private By CHECKOUT_BTN = AppiumBy.accessibilityId("test-CHECKOUT");
    private By TEST_ITEM_LOCATOR = AppiumBy.accessibilityId("test-Item");
    private By CART_ICON_QTY =By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.view.ViewGroup");

}

