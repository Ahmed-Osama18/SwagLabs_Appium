package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage {

    //////////////////////// constructor
    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    //////////////////////// actions
    public CheckoutInformationPage enterFirstname(String firstname)
    {
        driver.findElement(FIRSTNAME_TextBox).sendKeys(firstname);
        return this;
    }
    public CheckoutInformationPage enterLastname(String lastname)
    {
        driver.findElement(LASTNAME_TextBox).sendKeys(lastname);
        return this;
    }
    public CheckoutInformationPage enterPostalCode(String code)
    {
        driver.findElement(POSTALCODE_TextBox).sendKeys(code);
        return this;
    }

    public CheckoutOverviewPage clickOnContinue()
    {
        driver.findElement(CONTINUE_BTN).click();
        return new CheckoutOverviewPage(driver);
    }

    //////////////////// driver and locators
    private WebDriver driver;
    private By FIRSTNAME_TextBox =new AppiumBy.ByAccessibilityId("test-First Name");
    private By LASTNAME_TextBox =new AppiumBy.ByAccessibilityId("test-Last Name");
    private By POSTALCODE_TextBox =new AppiumBy.ByAccessibilityId("test-Zip/Postal Code");
    private By CONTINUE_BTN =new AppiumBy.ByAccessibilityId("test-CONTINUE");
    
}
