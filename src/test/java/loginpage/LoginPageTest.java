package loginpage;
import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.io.ByteArrayInputStream;


public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;
    public final By errorBox = By.xpath("//*[@id=\"userloginForm\"]/form/div[1]");
    public final By avatara =By.xpath("//*[@id=\"pt-userpage\"]/a");
    public final By logoutButton =By.xpath("//*[@id=\"pt-logout\"]/a");


    @Test
    public void validLoginCheck() {
        homePage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.typeUserName(user);
        loginPage.typePassword(pass);
        loginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, 25);
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(avatara));
        Assertions.assertEquals("KisVirág9", avatar.getText());

    }

    @Test
    public void validLoginCheck2() {
        homePage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.typeUserName(user);
        loginPage.typePassword(pass);
        loginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, 25);
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(avatara));
        Assertions.assertTrue(driver.findElement(logoutButton).isDisplayed());
    }

    @Test
    public void invalidLoginCheck() {
        homePage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.typeUserName(userFalse);
        loginPage.typePassword(passFalse);
        loginPage.clickLoginButton();
        Assertions.assertTrue(driver.findElement(errorBox).isDisplayed());
    }

    @Test
    public void invalidLoginCheck2() {
        homePage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.typeUserName(userFalse);
        loginPage.typePassword(passFalse);
        loginPage.clickLoginButton();
        TakeScreenshot();
        Assertions.assertTrue(driver.findElement(errorBox).getText().contains("Incorrect"));
    }

    @Step("TakeScreenshot")
    public void TakeScreenshot(){
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void ZeroLogInTest() {
        homePage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.typeUserName(userFalse2);
        loginPage.typePassword(passFalse2);
        loginPage.clickLoginButton();
        Assertions.assertTrue(driver.findElement(errorBox).isDisplayed());
    }

    @Test
    public void ZeroLogInTest2() {
        homePage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.typeUserName(userFalse2);
        loginPage.typePassword(passFalse2);
        loginPage.clickLoginButton();
        Assertions.assertTrue(driver.findElement(errorBox).getText().contains("could not be authenticated"));
    }
}
