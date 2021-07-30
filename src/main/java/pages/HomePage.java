package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    String URL = "https://en.wikipedia.org/wiki/Main_Page";
    private final By loginButton = By.xpath("//*[@id=\"pt-login\"]/a");

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

    public FirstPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new FirstPage(driver);
    }

}


