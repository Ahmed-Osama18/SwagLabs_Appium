package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    //////////////////////// constructor
    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    //////////////////////// actions
    public void validateSuccessPurchase(String text)
    {
        driver.findElement(SUCCESS_MSG).getText().equalsIgnoreCase(text);
    }

    //////////////////// driver and locators
    private WebDriver driver;
    private By SUCCESS_MSG = AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]");

}
