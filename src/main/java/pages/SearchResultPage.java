package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.util.List;

public class SearchResultPage {

    private WebDriver driver;
    public SearchResultPage(WebDriver driver) {
        this.driver=driver;
    }

    private final By Next250link = By.xpath("//*[@id='mw-content-text']/div[3]/p[2]/a[1]");
    List<WebElement> links;

    WebDriverWait wait;

    Utils utils=new Utils(driver);

    public void searchThroughMorePages() {
        Utils.scrollDown(driver);
        driver.findElement(Next250link).click();   //oldal alján next 250 button
        for (int l = 1; l <= 3; l++) {
            links = driver.findElements(By.xpath("//*[@id='mw-content-text']/div[3]/ul/li"));
            for (WebElement webElement : links) {
                WebElement link = webElement.findElement(By.xpath(".//a"));
                System.out.println(link.getText());
            }
            /*try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mw-content-text']/div[3]/p[2]/a[2]")));
                driver.findElement(By.xpath("//*[@id='mw-content-text']/div[3]/p[2]/a[2]")).click();
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();

            }*/
        }
    }
}
