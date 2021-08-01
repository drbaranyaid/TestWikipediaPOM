package firstPage;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.FirstPage;
import pages.HomePage;
import pages.LoginPage;


public class FirstPageTest extends BaseTest {

    FirstPage firstPage;
    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void LogoutTest() {
        loginPage = new LoginPage(driver);
        ValidLogin();
        firstPage = new FirstPage(driver);
        firstPage.clickLogoutButton();
        homePage = new HomePage(driver);
        Assertions.assertTrue(driver.findElement(homePage.loginButton).getText().contains("Log in"));
    }

    @Test
    public void SaveToFile() {
        loginPage = new LoginPage(driver);
        ValidLogin();
        firstPage = new FirstPage(driver);
        firstPage.writeToAFile();
    }
}
