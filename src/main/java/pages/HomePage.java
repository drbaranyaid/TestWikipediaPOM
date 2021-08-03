package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    public final By loginButton = By.xpath("//*[@id=\"pt-login\"]/a");
    private final By createAccountButton = By.xpath("//*[@id=\"pt-createaccount\"]/a");
    private final By privacyPolicyButton = By.xpath("//*[@id='footer-places-privacy']/a");
    private final By SearchInputField = By.xpath("//*[@id='searchInput']");
    private final By SearchButton =By.xpath("//*[@id='searchButton']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickCreateAccountButton(){
        driver.findElement(createAccountButton).click();
        new CreateAccountPage(driver);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
        new FirstPage(driver);
    }
    public void clickPrivacyPolicyButton(){
        driver.findElement(privacyPolicyButton).click();
        new PrivacyPolicyPage(driver);
    }

    public void searchData() {
        driver.findElement(SearchInputField).sendKeys("font types");
        driver.findElement(SearchButton).click();
        new SearchResultPage(driver);
    }

    public void searchDataGreenTea() {
        driver.findElement(SearchInputField).sendKeys("Green tea");
        driver.findElement(SearchButton).click();
        new SearchResultPage(driver);
    }

    }



