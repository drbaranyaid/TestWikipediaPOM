package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CreateAccountPage {
    private WebDriver driver;
    private final By createUserName = By.xpath("//*[@id='wpName2']");
    private final By createPassword = By.cssSelector("#wpPassword2");
    private final By confirmPassword = By.xpath("//*[@id='wpRetype']");
    private final By EmailField = By.xpath(("//*[@id='wpEmail']"));
    private final By createAccountButton =By.xpath("//button[@id='wpCreateaccount']");

    public CreateAccountPage(WebDriver driver) {
        this.driver=driver;
    }
    public void typeUserNameToCreateAccount(String user){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(createUserName).sendKeys(user);
    }
    public void typePasswordToCreateAccount(String pass){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(createPassword).sendKeys(pass);
    }

    public void typeEmailToCreateAccount(String email){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(EmailField).sendKeys(email);
    }
    public FirstPage clickCreateAccountButton(){
        driver.findElement(createAccountButton).click();
        return new FirstPage(driver);
    }
}
