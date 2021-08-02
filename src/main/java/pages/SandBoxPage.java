package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SandBoxPage {

    public WebDriver driver;
    public final By textfield = By.xpath("//*[@id=\"wpTextbox1\"]");

    public SandBoxPage(WebDriver driver) {
        this.driver = driver;
    }


    public void textFieldClear() {
        WebElement textfield = driver.findElement(By.xpath("//*[@id=\"wpTextbox1\"]"));
        textfield.clear();
    }

    public void textFieldSendData(String text) {
        WebElement textfield = driver.findElement(By.xpath("//*[@id=\"wpTextbox1\"]"));
        textfield.sendKeys(text);
    }

    public void clickShowPreviewButton() {
        driver.findElement(By.xpath("//*[@id=\"wpPreview\"]")).click();
    }

    public void textFieldClick() {
        WebElement textfield = driver.findElement(By.xpath("//*[@id=\"wpTextbox1\"]"));
        textfield.click();
    }

    public void repeatedMultiInput() {
        for (int j = 0; j < 9; j++) {
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

        Utils utils = new Utils(driver);
        utils.setWait("//*[@id=\"wpPreview\"]");
        clickShowPreviewButton();
        utils.setWait("//*[@id=\"wpTextbox1\"]");


    }



}
