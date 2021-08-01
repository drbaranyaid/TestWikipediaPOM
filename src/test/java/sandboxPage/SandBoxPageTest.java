package sandboxPage;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FirstPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SandBoxPage;
import utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SandBoxPageTest extends BaseTest {

    FirstPage firstPage;
    HomePage homePage;
    LoginPage loginPage;
    Utils utils;

    @Test
    public void repeatedData() throws InterruptedException {
        ValidLogin();
        FirstPage firstPage = new FirstPage(driver);
        firstPage.clickSandBoxButton();
        SandBoxPage sandboxPage = new SandBoxPage(driver);
        sandboxPage.textFieldClear();
        sandboxPage.repeatedMultiInput();
        Assertions.assertFalse(driver.findElement(By.xpath("//*[@id=\"wpTextbox1\"]")).getText().contains("bicikli"));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"wpTextbox1\"]")).getText().contains("A picike papucs."));
    }

    @Test
    public void InputClearModifyData() throws InterruptedException {
        loginPage = new LoginPage(driver);
        ValidLogin();
        firstPage = new FirstPage(driver);
        firstPage.clickSandBoxButton();
        SandBoxPage sandboxPage = new SandBoxPage(driver);
        sandboxPage.textFieldSendData("I am an old data, you need to change me!");
        utils = new Utils(driver);
        Utils.scrollDown(driver);
        utils.setWait("//*[@id=\"wpPreview\"]");
        SandBoxPage sandboxPage2 = new SandBoxPage(driver);
        sandboxPage2.clickShowPreviewButton();
        utils.setWait("//*[@id=\"wpPreview\"]");
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"wpTextbox1\"]")).getText().contains("I am an old data, you need to change me!"));
        sandboxPage.textFieldClick();
        sandboxPage.textFieldClear();
        sandboxPage.clickShowPreviewButton();
        utils.setWait("//*[@id=\"wpPreview\"]");
        Assertions.assertFalse(driver.findElement(By.xpath("//*[@id=\"wpTextbox1\"]")).getText().contains("I am an old data"));
        sandboxPage.textFieldClick();
        sandboxPage.textFieldSendData("I am the new data!");
        utils = new Utils(driver);
        Utils.scrollDown(driver);
        utils.setWait("//*[@id=\"wpPreview\"]");
        sandboxPage.clickShowPreviewButton();
        utils.setWait("//*[@id=\"wpPreview\"]");
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"wpTextbox1\"]")).getText().contains("I am the new data!"));

    }
}

