package searchResultPage;

import pages.HomePage;
import pages.SearchResultPage;
import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class SearchResultPageTest extends BaseTest {

    private final By Next20 = By.xpath("//*[@id='mw-content-text']/div[3]/p[2]/a[1]");
    private final By ResultField = By.xpath("//*[@id=\"mw-content-text\"]/div[3]/p[1]/i/a[1]");

    @Test
    public void SearchPagesListCheck() {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        homePage.searchDataGeneral("Font types");
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
                "Computer Modern\n" + "Fallback font\n" +
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
                "Fallback font\n" +
                "Typeface anatomy\n" +
                "Constantia (typeface)\n" +
                "Candara\n" +
                "Computer Modern\n" +
                "Croscore fonts\n" +
                "Ubuntu (typeface)\n";

        String linktext = searchResultPage.SearchPages();
        searchResultPage.ClickNext();
        String linktext2 = linktext + searchResultPage.SearchPages();
        Assertions.assertEquals(result, linktext2);
    }

    @Test
    public void SearchMorePagesTest2() {
        HomePage homePage = new HomePage(driver);
        homePage.searchDataGeneral("Font types");
        Assertions.assertEquals("Font types", driver.findElement(ResultField).getText());
        Assertions.assertEquals("next 20", driver.findElement(Next20).getText());
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.ClickNext();
        Assertions.assertEquals("Font types", driver.findElement(ResultField).getText());
        Assertions.assertEquals("previous 20", driver.findElement(Next20).getText());
    }

    @Test
    public void SearchPagesContainsCheck() {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        homePage.searchDataGeneral("Font types");
        String linktext = searchResultPage.SearchPages();
        searchResultPage.ClickNext();
        String linktext2 = linktext + searchResultPage.SearchPages();
        Assertions.assertTrue(linktext2.contains("font"));
    }

    @Test
    public void SearchOnePageResultCheck() {
        homePage.searchDataGeneral("Font types");
        Assertions.assertEquals("Font types", driver.findElement(ResultField).getText());
        Assertions.assertEquals("next 20", driver.findElement(Next20).getText());
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assertions.assertTrue(searchResultPage.SearchPages().contains("font"));
    }


    @Test
    public void testDataList() {
        homePage.searchDataGeneral("green tea");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assertions.assertTrue(searchResultPage.GreenTeaCheck());
    }

    @Test
    public void testDataListNumber() {
        homePage.searchDataGeneral("green tea");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assertions.assertEquals(200,searchResultPage.GreenTeaCheckNumber());

    }

    @Test
    public void SearchPagesTestSearchFieldShortDataTest() {
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
        String result = "Daihatsu\n" +
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
                "Daihatsu Compagno\n" +
                "Daihatsu New Global Architecture\n";
        Assertions.assertEquals(result, searchResultPage.SearchPages());
    }
}

