package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //////////////////////// constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //////////////////////// actions
    public LoginPage enterUsername (String username)
    {
        driver.findElement(USERNAME_TextBox).sendKeys(username);
        return this;
    }
    public LoginPage enterPassword (String password)
    {
        driver.findElement(PASSWORD_TextBox).sendKeys(password);
        return this;
    }
    public ProductsPage clickLogin ()
    {
        driver.findElement(LOGIN_BTN).click();
        return new ProductsPage(driver);
    }
    public String getErrorMessage() {
        return driver.findElement(ERROR_MSG_Label).getText();
    }

    //////////////////// driver and locators
    private WebDriver driver;
    private By USERNAME_TextBox = AppiumBy.accessibilityId("test-Username");
    private By PASSWORD_TextBox = AppiumBy.accessibilityId("test-Password");
    private By LOGIN_BTN = AppiumBy.accessibilityId("test-LOGIN");
    private By ERROR_MSG_Label = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");



}
