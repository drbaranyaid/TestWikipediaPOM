package searchResultPage;

import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.SearchResultPage;
import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.List;

public class  SearchResultPageTest extends BaseTest {
    @Test
    public void SearchMorePagesListCheck() {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        homePage.searchData();
        searchResultPage.searchThroughMorePages();
        Assertions.assertEquals("Font types", driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/p[1]/i/a[1]")).getText());
        Assertions.assertEquals("20", driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/p[2]/a[2]")).getText());
    }

    @Test
    public void testDataList() {
        homePage.searchDataGreenTea();
        boolean isTestDataList = false;
        int number = 0;
        List<WebElement> words = driver.findElements(By.xpath("//*"));
        for (WebElement element : words) {
            try {
                if (element.getText().contains("Green tea")) {
                    System.out.println(element.getText());
                    number += 1;
                    isTestDataList = true;

                }
            } catch (Exception ignored) {

            }
        }
        System.out.println("'Green tea' is found: " + number + " times.");

        Assertions.assertTrue(isTestDataList);
    }

    @Test
    public void SearchPagesTest() {
        HomePage homePage = new HomePage(driver);
        homePage.searchData();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.SearchPages();
        Assertions.assertEquals("Font types", driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/p[1]/i/a[1]")).getText());
        Assertions.assertEquals("next 20", driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/p[2]/a[2]")).getText());
    }
    @Test
    public void SearchPagesTest2() {
        HomePage homePage = new HomePage(driver);
        homePage.searchData();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.SearchPages2();
        Assertions.assertEquals("Font types", driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/p[1]/i/a[1]")).getText());
        Assertions.assertEquals("next 20", driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/p[2]/a[2]")).getText());
        // hány count van assertben, másik függvényben kiszedem a tartalmat benne van-e az elem
    }

}

