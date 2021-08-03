package createAccountPage;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.CreateAccountPage;

import java.io.ByteArrayInputStream;


public class createAccountPageTest extends BaseTest {

    @Test
    public void CreateAccountCheck() {
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        homePage.clickCreateAccountButton();
        createAccountPage.typeUserNameToCreateAccount(user);
        createAccountPage.typePasswordToCreateAccount(pass);
        createAccountPage.typeEmailToCreateAccount(email);
        TakeScreenshot2();
        createAccountPage.clickCreateAccountButton();
        TakeScreenshot2();
        Assertions.assertEquals("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Main+Page", getDriver().getCurrentUrl());
    }
    @Step("TakeScreenshot2")
    public void TakeScreenshot2(){
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());
    }

}
