package searchResultPage;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.SearchResultPage;
import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Locale;

public class  SearchResultPageTest extends BaseTest {
    @Test
    public void SearchMorePagesListCheck() {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        homePage.searchData();
        String result = "Font types\n" +
                "Ubuntu (typeface)\n" +
                "Baptismal font\n" +
                "Bitstream Speedo font\n" +
                "Monospaced font\n" +
                "Oblique type\n" +
                "Lucida\n" +
                "Georgia (typeface)\n" +
                "Fonts on Macintosh\n" +
                "Adobe Fonts\n" +
                "Hobo (typeface)\n" +
                "Type foundry\n" +
                "Droid fonts\n" +
                "Emphasis (typography)\n" +
                "Cambria (typeface)\n" +
                "Fallback font\n" +
                "Typeface anatomy\n" +
                "Constantia (typeface)\n" +
                "Candara\n" +
                "Computer Modern\n" +
                "Croscore fonts\n" +
                "Ubuntu (typeface)\n" +
                "Baptismal font\n" +
                "Bitstream Speedo Fonts\n" +
                "Monospaced font\n" +
                "Oblique type\n" +
                "Lucida\n" +
                "Georgia (typeface)\n" +
                "Fonts on Macintosh\n" +
                "Adobe Fonts\n" +
                "Hobo (typeface)\n" +
                "Type foundry\n" +
                "Droid fonts\n" +
                "Emphasis (typography)\n" +
                "Cambria (typeface)\n" +
                "Fallback font\n" +
                "Typeface anatomy\n" +
                "Constantia (typeface)\n" +
                "Candara\n" +
                "Computer Modern\n";
        searchResultPage.SearchPages();
        searchResultPage.ClickNext();
        Assertions.assertEquals(result,searchResultPage.SearchPages());
    }

    @Test
    public void SearchMorePagesTest2() {
        HomePage homePage = new HomePage(driver);
        homePage.searchData();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.SearchPages();
        Assertions.assertEquals("Font types", driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/p[1]/i/a[1]")).getText());
        Assertions.assertEquals("next 20", driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/p[2]/a[2]")).getText());
    }

    @Test
    public void SearchMorePagesResultCheck() {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        homePage.searchData();
        Assertions.assertEquals("Font types", driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/p[1]/i/a[1]")).getText());
        Assertions.assertEquals("20", driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/p[2]/a[2]")).getText());}


    @Test
    public void testDataList(){
        homePage.searchDataGreenTea();
        boolean isTestDataList = false;
        int number = 0;
        List<WebElement> words = driver.findElements(By.xpath("//*"));
        for (WebElement element : words) {
            try {
                if (element.getText().toLowerCase().contains("Green tea".toLowerCase())) {
                    System.out.println(element.getText());
                    number += 1;
                    isTestDataList = true;
                }
            } catch (Exception ignored) {
            }
        }
        System.out.println(number);
        Assertions.assertEquals(200,number);
        Assertions.assertTrue(isTestDataList);
    }


    @Test
    public void SearchPagesTestSearchField2() {
        HomePage homePage = new HomePage(driver);
        homePage.searchDataGeneral("Daihatsu types");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assertions.assertTrue(searchResultPage.SearchPages().contains("Daihatsu"));
        searchResultPage.ClickNext();
        Assertions.assertTrue(searchResultPage.SearchPages().contains("Daihatsu Wake"));
    }

    @Test
    public void SearchPagesTestListCheck2() {
        HomePage homePage = new HomePage(driver);
        homePage.searchDataGeneral("Daihatsu types");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.SearchPages();
        searchResultPage.ClickNext();
        String result="Daihatsu\n" +
                "Daihatsu Move\n" +
                "Daihatsu Copen\n" +
                "Astra Daihatsu Motor\n" +
                "Daihatsu Tanto\n" +
                "Daihatsu Terios\n" +
                "Daihatsu E-series engine\n" +
                "Daihatsu Charade\n" +
                "Daihatsu Rugger\n" +
                "Daihatsu Midget\n" +
                "Daihatsu Hijet\n" +
                "Daihatsu Mira\n" +
                "Daihatsu Charmant\n" +
                "Toyota SZ engine\n" +
                "Daihatsu K-series engine\n" +
                "Daihatsu Boon\n" +
                "Toyota Avanza\n" +
                "Daihatsu Cast\n" +
                "Daihatsu New Global Architecture\n" +
                "Toyota bB\n" +
                "Daihatsu\n" +
                "Daihatsu Move\n" +
                "Daihatsu Copen\n" +
                "Astra Daihatsu Motor\n" +
                "Daihatsu Tanto\n" +
                "Daihatsu Terios\n" +
                "Daihatsu E-series engine\n" +
                "Daihatsu Charade\n" +
                "Daihatsu Rugger\n" +
                "Daihatsu Midget\n" +
                "Daihatsu Hijet\n" +
                "Daihatsu Mira\n" +
                "Daihatsu Charmant\n" +
                "Toyota SZ engine\n" +
                "Daihatsu K-series engine\n" +
                "Daihatsu Boon\n" +
                "Toyota Avanza\n" +
                "Daihatsu Cast\n" +
                "Daihatsu Compagno\n"+
                "Daihatsu New Global Architecture\n";
        Assertions.assertEquals(result,searchResultPage.SearchPages());
    }
}

