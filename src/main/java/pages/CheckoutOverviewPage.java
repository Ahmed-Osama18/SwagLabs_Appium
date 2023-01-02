package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

    //////////////////////// constructor
    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    //////////////////////// actions
    public String getPriceInOverviewPage()
    {
        return driver.findElement(ITEM_TOTAL_LABEL).getText();
    }

    public String getTotalInOverviewPage()
    {
        return driver.findElement(TOTAL_WITH_TAXES_LABEL).getText();
    }

    public CheckoutCompletePage clickOnFinish()
    {
        driver.findElement(FINISH_BTN).click();
        return new CheckoutCompletePage(driver);
    }

    //////////////////// driver and locators
    private WebDriver driver;
    private By FINISH_BTN = AppiumBy.accessibilityId("test-FINISH");
    private By ITEM_TOTAL_LABEL = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");
    private By TOTAL_WITH_TAXES_LABEL = AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[7]");

}
