package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setBaseurl() {
        openBrowser(baseUrl);
        System.out.println("Opening the Browser");
    }
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
    // click on forgot password link
        WebElement forgotPassword = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']") );
        forgotPassword.click();

        String expectedText = "Reset Password";
        WebElement actualTextElement = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']"));
        String actualText = actualTextElement.getText();
        // verifying expected and actual text
        Assert.assertEquals(expectedText , actualText) ;
    }
}
