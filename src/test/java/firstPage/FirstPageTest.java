package firstPage;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FirstPage;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
