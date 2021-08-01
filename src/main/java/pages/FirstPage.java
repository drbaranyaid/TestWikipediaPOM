package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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

    public void writeToAFile() {
        try {
            FileWriter fileWriter = new FileWriter("SaveToFile.txt");
            fileWriter.append(driver.findElement(By.xpath("//*[@id=\"mp-itn\"]")).getText() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String data = "";
        try {
            File file = new File("SaveToFile.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data += scanner.nextLine();
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(data);
        Assertions.assertTrue(data.contains("Road"));
    }


}




