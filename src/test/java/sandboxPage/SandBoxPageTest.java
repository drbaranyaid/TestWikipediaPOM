package sandboxPage;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import pages.FirstPage;
import pages.LoginPage;
import pages.SandBoxPage;
import utils.Utils;


public class SandBoxPageTest extends BaseTest {

    FirstPage firstPage;
    LoginPage loginPage;
    Utils utils;

    @Test
    public void repeatedData(){
        ValidLogin();
        FirstPage firstPage = new FirstPage(driver);
        Utils utils = new Utils(driver);
        utils.setWait("//*[@id=\"pt-sandbox\"]/a");
        firstPage.clickSandBoxButton();
        SandBoxPage sandboxPage = new SandBoxPage(driver);
        sandboxPage.textFieldClear();
        sandboxPage.repeatedMultiInput();
        Assertions.assertFalse(driver.findElement(By.xpath("//*[@id=\"wpTextbox1\"]")).getText().contains("bicikli"));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"wpTextbox1\"]")).getText().contains("A picike papucs."));
    }

    @Test
    public void InputClearModifyData(){
        loginPage = new LoginPage(driver);
        ValidLogin();
        firstPage = new FirstPage(driver);
        Utils utils = new Utils(driver);
        utils.setWait("//*[@id=\"pt-sandbox\"]/a");
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

