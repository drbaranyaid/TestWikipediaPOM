package homepage;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

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
    @Test
    public void PrivacyPolicyUse() {
        homePage.clickPrivacyPolicyButton();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 5000)");
        Assertions.assertEquals("Privacy policy", driver.findElement(By.xpath("//*[@id='mw-normal-catlinks']/ul/li[1]/a")).getText());
    }

    @Test
    public void testPrivacyAndPolicyLink() {
        homePage.clickPrivacyPolicyButton();
        Assertions.assertEquals("https://foundation.wikimedia.org/wiki/Privacy_policy", driver.getCurrentUrl());
    }
    @Test
    public void SearchDataLink() {
        homePage.searchData();
        Assertions.assertEquals("https://en.wikipedia.org/w/index.php?search=font+types&title=Special%3ASearch&go=Go&ns0=1", driver.getCurrentUrl());
        }
    }

