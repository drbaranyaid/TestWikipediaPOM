package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;
    String URL = "https://en.wikipedia.org/wiki/Main_Page";

    private final By userName = By.xpath("//*[@id=\"wpName1\"]");
    private final By passwordButton = By.cssSelector("#wpPassword1");
    private final By loginFinalButton =By.cssSelector("#wpLoginAttempt");
    public final By errorbox = By.xpath("//*[@id=\"userloginForm\"]/form/div[1]");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public void typeUserName(String user){
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(userName).sendKeys(user);
    }
    public void typePassword(String pass){
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(passwordButton).sendKeys(pass);
    }
    public FirstPage clickLoginButton(){
        driver.findElement(loginFinalButton).click();
        return new FirstPage(driver);
    }


}
