package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Utils {
    WebDriver driver;
    public Utils(WebDriver driver) {
        this.driver=driver;
    }

    public static void scrollDown(WebDriver driver){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 500)");
        }

        public static void refresh(WebDriver driver){
            driver.navigate().refresh();
        }
    }

