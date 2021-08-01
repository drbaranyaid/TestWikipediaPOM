package createAccountPage;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CreateAccountPage;


public class createAccountPageTest extends BaseTest {

    @Test
    public void CreateAccountCheck() {
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        homePage.clickCreateAccountButton();
        createAccountPage.typeUserNameToCreateAccount(user);
        createAccountPage.typePasswordToCreateAccount(pass);
        createAccountPage.typeEmailToCreateAccount(email);
        createAccountPage.clickCreateAccountButton();
        //keresd meg a pop-up windowt!
        Assertions.assertEquals("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Main+Page", getDriver().getCurrentUrl());
    }
}
