package homepage;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.Utils;

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
        Utils utils=new Utils(driver);
        Utils.scrollDown(driver);
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

    @Test
    public void SearchRepeatedData() {
        homePage.repeatedMultiInputSearch();
        homePage.searchData();
        Assertions.assertEquals("https://en.wikipedia.org/w/index.php?search=The+black+tea+bad+effects+to+an+organismfont+types&title=Special%3ASearch&go=Go&ns0=1", driver.getCurrentUrl());
        Assertions.assertTrue(homePage.FindingDiv());
    }

    @Test
    public void SearchRepeatedDataCheckedWithAllData() {
        homePage.repeatedMultiInputSearch();
        homePage.searchData();
        Assertions.assertEquals("https://en.wikipedia.org/w/index.php?search=The+black+tea+bad+effects+to+an+organismfont+types&title=Special%3ASearch&go=Go&ns0=1", driver.getCurrentUrl());
        Assertions.assertTrue(homePage.FindingDivGeneral("black tea bad effects"));
    }

    @Test
    public void SearchInputClearModifyData() {
        homePage.searchDataGeneral("old data");
        Assertions.assertEquals("https://en.wikipedia.org/w/index.php?search=old+data&title=Special%3ASearch&go=Go&ns0=1", driver.getCurrentUrl());
        By SEARCH_RESULT = By.xpath("//*[@id=\"ooui-php-1\"]");
        String result = driver.findElement(SEARCH_RESULT).getAttribute("value");
        Assertions.assertEquals("old data", result);
        Assertions.assertTrue(homePage.FindingDivGeneral("data"));
        driver.findElement(SEARCH_RESULT).clear();
        String result2 = driver.findElement(SEARCH_RESULT).getAttribute("value");
        Assertions.assertEquals("", result2);
        driver.findElement(SEARCH_RESULT).sendKeys("new data modification");
        driver.findElement(By.xpath("//*[@id=\"mw-search-top-table\"]/div[1]/div/div/span/span/button/span[2]")).click();
        Assertions.assertEquals("https://en.wikipedia.org/w/index.php?search=new+data+modification&title=Special:Search&profile=advanced&fulltext=1&ns0=1", driver.getCurrentUrl());
        Assertions.assertTrue(homePage.FindingDivGeneral("New"));


    }
}





