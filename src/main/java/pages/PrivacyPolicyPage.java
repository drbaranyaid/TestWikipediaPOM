package pages;

import org.openqa.selenium.WebDriver;

public class PrivacyPolicyPage {
    private final WebDriver driver;

    public PrivacyPolicyPage(WebDriver driver) {
        this.driver=driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
