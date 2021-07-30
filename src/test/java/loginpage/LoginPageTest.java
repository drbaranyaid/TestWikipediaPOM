package loginpage;
import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;


public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;
    public final By errorbox = By.xpath("//*[@id=\"userloginForm\"]/form/div[1]");
    @Test
    public void loginCheck() {
        homePage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.typeUserName(user);
        loginPage.typePassword(pass);
        loginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, 25);
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pt-userpage\"]/a")));
        Assertions.assertEquals("KisVirág9", avatar.getText());
    }
    @Test
    public void invalidLoginCheck() {
        homePage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.typeUserName(userFalse);
        loginPage.typePassword(passFalse);
        loginPage.clickLoginButton();
        Assertions.assertTrue(driver.findElement(errorbox).isDisplayed());
    }

}
