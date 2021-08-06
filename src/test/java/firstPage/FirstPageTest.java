package firstPage;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.FirstPage;
import pages.HomePage;
import pages.LoginPage;


public class FirstPageTest extends BaseTest {

    FirstPage firstPage;
    HomePage homePage;
    LoginPage loginPage;

    public By searchedField = By.xpath("//*[@id=\"mp-itn\"]");

    @Test
    public void LogoutTest() {
        loginPage = new LoginPage(driver);
        loginPage.ValidLogin();
        firstPage = new FirstPage(driver);
        firstPage.clickLogoutButton();
        homePage = new HomePage(driver);
        Assertions.assertTrue(driver.findElement(homePage.loginButton).getText().contains("Log in"));
    }

    @Test
    public void LogoutTest2() {
        loginPage = new LoginPage(driver);
        loginPage.ValidLogin();
        firstPage = new FirstPage(driver);
        firstPage.clickLogoutButton();
        homePage = new HomePage(driver);
        Assertions.assertEquals("https://en.wikipedia.org/wiki/Main_Page",driver.getCurrentUrl());
    }

    @Test
    public void SaveToFile() {
        loginPage = new LoginPage(driver);
        loginPage.ValidLogin();
        firstPage = new FirstPage(driver);
        firstPage.writeToAFile();
        Assertions.assertTrue(firstPage.writeToAFile().toString().contains("Nominate an article"));
        Assertions.assertEquals(driver.findElement(searchedField).getText()+"\n",firstPage.writeToAFile().toString());
    }
}
