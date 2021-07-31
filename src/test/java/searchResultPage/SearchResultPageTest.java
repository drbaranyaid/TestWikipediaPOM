package searchResultPage;
import pages.SearchResultPage;
import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SearchResultPageTest extends BaseTest {
    @Test
    public void loginCheck() {
        SearchResultPage searchResultPage=new SearchResultPage(driver);
        homePage.searchData();
        searchResultPage.searchThroughMorePages();
        Assertions.assertEquals("Font types", driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/p[1]/i/a[1]")).getText());
        Assertions.assertEquals("next 20", driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/p[2]/a[2]")).getText());
    }
}
