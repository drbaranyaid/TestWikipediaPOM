package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    String URL = "https://en.wikipedia.org/wiki/Main_Page";
    public final By loginButton = By.xpath("//*[@id=\"pt-login\"]/a");
    private final By createAccountButton = By.xpath("//*[@id=\"pt-createaccount\"]/a");
    private final By privacyPolicyButton = By.xpath("//*[@id='footer-places-privacy']/a");
    private final By SearchInputField = By.xpath("//*[@id='searchInput']");
    private final By SearchButton =By.xpath("//*[@id='searchButton']");

    public boolean isLoginButtonVisible(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public CreateAccountPage clickCreateAccountButton(){
        driver.findElement(createAccountButton).click();
        return new CreateAccountPage(driver);
    }
    public FirstPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new FirstPage(driver);
    }
    public PrivacyPolicyPage clickPrivacyPolicyButton(){
        driver.findElement(privacyPolicyButton).click();
        return new PrivacyPolicyPage(driver);
    }

    public SearchResultPage searchData() {
        driver.findElement(SearchInputField).sendKeys("font types");
        driver.findElement(SearchButton).click();
        return new SearchResultPage(driver);
    }

    public SearchResultPage searchDataGreenTea() {
        driver.findElement(SearchInputField).sendKeys("Green tea");
        driver.findElement(SearchButton).click();
        return new SearchResultPage(driver);
    }
    }



