package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.util.List;

public class SearchResultPage {

    private final WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By Next20 = By.xpath("//*[@id='mw-content-text']/div[3]/p[2]/a[1]");
    private final By RES_DIV = By.xpath("//*[@id='mw-content-text']/div[3]");
    private final By UL_LI = By.xpath("//*[@id='mw-content-text']/div[3]/ul/li");
    List<WebElement> div;
    List<WebElement> links;

    public void searchThroughMorePages() {
        for (int i = 1; i <= 2; i++) {
            links = driver.findElements(RES_DIV);
            for (WebElement webElement : links) {
                WebElement link = webElement.findElement(By.xpath(".//a"));
                System.out.println(link.getText());
            }
            Utils.scrollDown(driver);
            driver.findElement(Next20).click();
            for (int l = 1; l <= 2; l++) {
                links = driver.findElements(UL_LI);
                for (WebElement webElement : links) {
                    WebElement link = webElement.findElement(By.xpath(".//a"));
                    System.out.println(link.getText());
                }

            }
        }
    }

    public void SearchPages() {
        div = driver.findElements(UL_LI);
        for (WebElement webElement : div) {
            WebElement link = webElement.findElement(By.xpath(".//a"));
            System.out.println(link.getText());
        }
        Utils.scrollDown(driver);
        driver.findElement(Next20).click();
        div = driver.findElements(UL_LI);
        for (WebElement webElement : div) {
            WebElement link = webElement.findElement(By.xpath(".//a"));
            System.out.println(link.getText());
        }
    }

    public int SearchPages2() {
        int count = 0;
        while (true) {
            div = driver.findElements(UL_LI);
            for (WebElement webElement : div) {
                WebElement link = webElement.findElement(By.xpath(".//a"));
                System.out.println(link.getText());
            }
            Utils.scrollDown(driver);
            if (isClickable(Next20) && count<=2) {
                driver.findElement(Next20).click();
                count++;
            } else {
                break;
            }
        }
        return count;
    }


    public boolean isClickable(By webE) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(webE));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}


