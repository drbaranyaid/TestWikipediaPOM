package homepage;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageTest extends BaseTest {

    @Test
    public void pageCheckLogin() {
        homePage.clickLoginButton();
        Assertions.assertEquals("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page", getDriver().getCurrentUrl());
    }
    @Test
    public void pageCheckCreateAccount() {
        homePage.clickCreateAccountButton();
        Assertions.assertEquals("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Main+Page", getDriver().getCurrentUrl());
    }
}
