package sandboxPage;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FirstPage;
import pages.SandBoxPage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SandBoxPageTest extends BaseTest {
    public final By textfield = By.xpath("//*[@id=\"wpTextbox1\"]");

    @Test
    public void repeatedData() throws InterruptedException {
        ValidLogin();
        FirstPage firstPage = new FirstPage(driver);
        firstPage.clickSandBoxButton();
        SandBoxPage sandboxPage = new SandBoxPage(driver);
        sandboxPage.textFieldClear();
        sandboxPage.repeatedMultiInput();
    }

}
