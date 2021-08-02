package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    private final By userName = By.xpath("//*[@id=\"wpName1\"]");
    private final By passwordButton = By.cssSelector("#wpPassword1");
    private final By loginFinalButton =By.cssSelector("#wpLoginAttempt");


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
    public void clickLoginButton(){
        driver.findElement(loginFinalButton).click();
        new FirstPage(driver);
    }
    public void ValidLogin(){
        String user = "KisVirág9";
        String pass = "kukac423";
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        typeUserName(user);
        typePassword(pass);
        clickLoginButton();

    }

}
