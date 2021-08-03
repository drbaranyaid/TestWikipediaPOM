package sandboxPage;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import pages.FirstPage;
import pages.LoginPage;
import pages.SandBoxPage;
import utils.Utils;

import java.io.ByteArrayInputStream;


public class  SandBoxPageTest extends BaseTest {

    FirstPage firstPage;
    LoginPage loginPage;

    public final By sandBox = By.xpath("//*[@id='pt-sandbox']/a");
    public final By textfield = By.xpath("//*[@id='wpTextbox1']");
    public final By preview = By.xpath("//*[@id='wpPreview']");

    @Test
    public void repeatedData() {
        homePage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.typeUserName(user);
        loginPage.typePassword(pass);
        loginPage.clickLoginButton();
        FirstPage firstPage = new FirstPage(driver);
        Utils utils = new Utils(driver);
        utils.setWait(sandBox);
        firstPage.clickSandBoxButton();
        driver.findElement(By.xpath( "//*[@id='noarticletext']/tbody/tr/td/ul/li[1]/b/a")).click();
        TakeScreenshot();
        SandBoxPage sandboxPage = new SandBoxPage(driver);
        sandboxPage.textFieldClear();
        sandboxPage.repeatedMultiInput();
        Assertions.assertFalse(driver.findElement(textfield).getText().contains("bicikli"));
        Assertions.assertTrue(driver.findElement(textfield).getText().contains("A picike papucs."));
    }
    @Step("TakeScreenshot")
    public void TakeScreenshot(){
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void InputClearModifyData() {
        homePage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.typeUserName(user);
        loginPage.typePassword(pass);
        loginPage.clickLoginButton();
        firstPage = new FirstPage(driver);
        Utils utils = new Utils(driver);
        utils.setWait(sandBox);
        firstPage.clickSandBoxButton();
        driver.findElement(By.xpath( "//*[@id='noarticletext']/tbody/tr/td/ul/li[1]/b/a")).click();
        TakeScreenshot();
        SandBoxPage sandboxPage = new SandBoxPage(driver);
        sandboxPage.textFieldSendData("I am an old data, you need to change me!");
        utils = new Utils(driver);
        Utils.scrollDown(driver);
        utils.setWait(preview);
        SandBoxPage sandboxPage2 = new SandBoxPage(driver);
        sandboxPage2.clickShowPreviewButton();
        utils.setWait(preview);
        Assertions.assertTrue(driver.findElement(textfield).getText().contains("I am an old data, you need to change me!"));
        sandboxPage.textFieldClick();
        sandboxPage.textFieldClear();
        sandboxPage.clickShowPreviewButton();
        utils.setWait(preview);
        Assertions.assertFalse(driver.findElement(textfield).getText().contains("I am an old data"));
        sandboxPage.textFieldClick();
        sandboxPage.textFieldSendData("I am the new data!");
        utils = new Utils(driver);
        Utils.scrollDown(driver);
        utils.setWait(preview);
        sandboxPage.clickShowPreviewButton();
        utils.setWait(preview);
        Assertions.assertTrue(driver.findElement(textfield).getText().contains("I am the new data!"));
    }

}

    /*
    //@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @Test
    //@Order(1)
    public void InputData() {
        loginPage = new LoginPage(driver);
        loginPage.ValidLogin();
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
    }

    @Test
    //@Order(2)
    public void ClearData() {
        InputData();
        SandBoxPage sandboxPage = new SandBoxPage(driver);
        sandboxPage.textFieldClick();
        sandboxPage.textFieldClear();
        sandboxPage.clickShowPreviewButton();
        Utils utils = new Utils(driver);
        utils.setWait("//*[@id=\"wpPreview\"]");
        Assertions.assertFalse(driver.findElement(By.xpath("//*[@id=\"wpTextbox1\"]")).getText().contains("I am an old data"));
    }

    @Test
    //@Order(3)
    public void NewData() {
        ClearData();
        SandBoxPage sandboxPage = new SandBoxPage(driver);
        sandboxPage.textFieldClick();
        sandboxPage.textFieldSendData("I am the new data!");
        Utils utils = new Utils(driver);
        Utils.scrollDown(driver);
        utils.setWait("//*[@id=\"wpPreview\"]");
        sandboxPage.clickShowPreviewButton();
        utils.setWait("//*[@id=\"wpPreview\"]");
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"wpTextbox1\"]")).getText().contains("I am the new data!"));}*/


