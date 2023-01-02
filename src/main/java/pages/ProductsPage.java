package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    //////////////////////// constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    //////////////////////// actions
    public String getProductsTitle() {

        return driver.findElement(PRODUCTS_TITLE).getText();
    }

    public ProductsPage addBackPackItemToCart() {
        driver.findElement(ADDTOCART_BTN).click();
        return this;
    }

    public CartPage openCart()
    {
        driver.findElement(CART_ICON).click();
        return new CartPage(driver);
    }

    public String getItemTitle_InProductPage() {
        return driver.findElement(ItemTitle).getText();
    }

    public String getItemPrice_InProductPage() {
        return driver.findElement(ItemPrice).getText();
    }

    //////////////////// driver and locators
    private WebDriver driver;
    private By PRODUCTS_TITLE = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Toggle\"]//parent::android.view.ViewGroup/android.widget.TextView");
    private By ADDTOCART_BTN = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]");
    private By CART_ICON = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");
    private By ItemTitle = By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]");
    private By ItemPrice = By.xpath("(//android.widget.TextView[@content-desc=\"test-Price\"])[1]");


}
