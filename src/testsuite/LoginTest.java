package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest  {
    String baseurl = "https://opensource-demo.orangehrmlive.com/";
   // WebDriver driver = new ChromeDriver();

    @Before
    public void setBaseurl() {
        openBrowser(baseurl);
        System.out.println("Opening the Browser");
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter username on userName field
        WebElement userNameField = driver.findElement(By.name("username"));
        userNameField.sendKeys("Admin");
        //Enter password on password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");
        // click on login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        // Verify the dashboard text display
        String expectedText = "Dashboard";
        WebElement actualTextElement = driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
        System.out.println("Closing browser");
    }
}