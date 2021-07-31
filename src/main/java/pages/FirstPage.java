package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstPage {
    public WebDriver driver;
    private final By logoutButton = By.cssSelector("#pt-logout > a");
    public final By sandBoxButton = (By.xpath(("//*[@id=\"pt-sandbox\"]/a")));
    SandBoxPage sandBoxPage = new SandBoxPage(driver);

    public FirstPage(WebDriver driver) {
        this.driver = driver;
    }

    public SpecialLogoutPage clickLogoutButton() {
        driver.findElement(logoutButton).click();
        return new SpecialLogoutPage(driver);
    }

    public SandBoxPage clickSandBoxButton() {
        driver.findElement(sandBoxButton).click();
        return new SandBoxPage(driver);
    }


}
