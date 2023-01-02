package tests;

import com.shaft.tools.io.JSONFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class LoginTest {

    // preconditions
    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver = new Common().setCapabilities();
        data = new JSONFileManager("src/test/resources/TestDataFiles/Data.json");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }

    //////////////////////////////// Tests \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    // login with valid username and password.
    @Test
    public void loginSuccessful() throws IOException {
        // login using correct credentials and get title of products page header
        String title = new LoginPage(driver)
                .enterUsername(data.getTestData("username"))
                .enterPassword(data.getTestData("password"))
                .clickLogin()
                .getProductsTitle();

        // validate that we are logged in successfully and now in products page (by page title).
        Assert.assertEquals(title,"PRODUCTS");

        // capture screenshot to project folder.
        new Common().captureScreenshot(driver,"LoginTest","loginSuccessful");
    }

    // login with valid email and invalid password.
    @Test
    public void loginFailed() throws IOException {
        // login using correct user name and wrong password
        new LoginPage(driver)
                .enterUsername(data.getTestData("username"))
                .enterPassword("123")
                .clickLogin();

        // validate that right error message appears successfully when user enter wrong password.
        Assert.assertTrue(new LoginPage(driver).getErrorMessage().contains(data.getTestData("error_msg")));

        // capture screenshot to project folder.
        new Common().captureScreenshot(driver,"LoginTest","loginFailed");
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
