package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstPage {
    private WebDriver driver;
    private final By logoutButton = By.cssSelector("#pt-logout > a");

    public FirstPage(WebDriver driver) {
        this.driver=driver;
    }

    public SpecialLogoutPage clickLogoutButton(){
        driver.findElement(logoutButton).click();
        return new SpecialLogoutPage(driver);
    }

}
