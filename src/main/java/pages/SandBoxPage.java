package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SandBoxPage {
    public WebDriver driver;
    public final By textfield = By.xpath("//*[@id=\"wpTextbox1\"]");
    public SandBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void textFieldClear(){
        WebElement textfield = driver.findElement(By.xpath("//*[@id=\"wpTextbox1\"]"));
        textfield.clear();
}
    public void repeatedMultiInput(){
        for (int j = 0; j < 4; j++) {
            try {
                File myfile = new File("src/main/resources/notes.txt");
                Scanner scanner = new Scanner(myfile);
                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    System.out.println();
                    driver.findElement(textfield).sendKeys(data + " ");

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wpPreview\"]"))).click();
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wpTextbox1\"]")));
        System.out.println(driver.findElement(By.xpath("//*[@id=\"wpTextbox1\"]")).getText());
        Assertions.assertFalse(driver.findElement(By.xpath("//*[@id=\"wpTextbox1\"]")).getText().contains("bicikli"));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"wpTextbox1\"]")).getText().contains("A picike papucs."));

    }
}
