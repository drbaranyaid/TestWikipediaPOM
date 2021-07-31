package firstPage;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FirstPage;
import pages.LoginPage;

public class FirstPageTest extends BaseTest {
    FirstPage firstPage;
    LoginPage loginPage;

    @Test
    public void LogoutTest() {
        loginPage = new LoginPage(driver);
        ValidLogin();
        firstPage = new FirstPage(driver);
        firstPage.clickLogoutButton();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id='pt-login']/a")).getText().contains("Log in"));
    }

}
