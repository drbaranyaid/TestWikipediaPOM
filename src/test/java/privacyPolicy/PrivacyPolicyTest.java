package privacyPolicy;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.HomePage;
import pages.LoginPage;
import pages.PrivacyPolicyPage;

public class PrivacyPolicyTest extends BaseTest {

    @Test
    public void PrivacyTestVersionCheck() {
        HomePage homePage = new HomePage(driver);
        homePage.clickPrivacyPolicyButton();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 5000)");
        PrivacyPolicyPage privacyPolicyPage=new PrivacyPolicyPage(driver);
        Assertions.assertEquals("Amanda Keton", privacyPolicyPage.getTextFromPolicy());
    }

    @Test
    public void PrivacyTestSummaryCheck() {
        HomePage homePage = new HomePage(driver);
        homePage.clickPrivacyPolicyButton();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 5000)");
        PrivacyPolicyPage privacyPolicyPage=new PrivacyPolicyPage(driver);
        privacyPolicyPage.getTextFromSummary();
        String result="Privacy Policy\n"+"This is a summary of the Privacy Policy. To read the full terms, scroll down or click here.\n" +
                "Disclaimer: This summary is not a part of the Privacy Policy and is not a legal document. It is simply a handy reference for understanding the full Privacy Policy. Think of it as the user-friendly interface to our Privacy Policy.\n" +
                "\n" +
                "Because we believe that you shouldn’t have to provide personal information to participate in the free knowledge movement, you may:\n" +

                "Read, edit, or use any Wikimedia Site without registering an account.\n" +
                "Register for an account without providing an email address or real name.\n" +
                "Because we want to understand how Wikimedia Sites are used so we can make them better for you, we collect some information when you:\n" +

                "Make public contributions.\n" +
                "Register an account or update your user page.\n" +
                "Use the Wikimedia Sites.\n" +
                "Send us emails or participate in a survey or give feedback.\n" +
                "We are committed to:\n" +
                "Describing how your information may be used or shared in this Privacy Policy.\n" +
                "Using reasonable measures to keep your information secure.\n" +
                "Never selling your information or sharing it with third parties for marketing purposes.\n" +
                "Only sharing your information in limited circumstances, such as to improve the Wikimedia Sites, to comply with the law, or to protect you and others.\n" +
                "Retaining your data for the shortest possible time that is consistent with maintaining, understanding, and improving the Wikimedia Sites, and our obligations under applicable law.\n" +
                "Be aware:\n" +
                "Any content you add or any change that you make to a Wikimedia Site will be publicly and permanently available.\n" +
                "If you add content or make a change to a Wikimedia Site without logging in, that content or change will be publicly and permanently attributed to the IP address used at the time rather than a username.\n" +
                "Our community of volunteer editors and contributors is a self-policing body. Certain administrators of the Wikimedia Sites, who are chosen by the community, use tools that grant them limited access to nonpublic information about recent contributions so they may protect the Wikimedia Sites and enforce policies.\n" +
                "This Privacy Policy does not apply to all sites and services run by the Wikimedia Foundation, such as sites or services that have their own privacy policy (like the Wikimedia Shop) or sites or services run by third parties (like third-party developer projects on Wikimedia Cloud Services).\n" +
                "As part of our commitment to education and research around the world, we occasionally release public information and aggregated or non-personal information to the general public through data dumps and data sets.\n" +
                "For the protection of the Wikimedia Foundation and other users, if you do not agree with this Privacy Policy, you may not use the Wikimedia Sites.";
        Assertions.assertEquals(result, privacyPolicyPage.getTextFromSummary());
    }

}
//(html/body/div[3]/div[3]/div[5]/div[1]/ul/li/b/a)