package DetailPageOnTest;

import java.io.IOException;

        import org.openqa.selenium.JavascriptExecutor;
        import org.testng.Assert;
        import org.testng.annotations.Test;

        import wrappers.Wrapper_methods;

public class DetailPage_CouldThisPageBeImproved_Yes extends Wrapper_methods {

    @Test

    public void DetailPage_CouldThisPageBeImproved_Yes() throws IOException {

        launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/D32670", "chrome");

        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // click yes option on could this page be improved?

        //clickbyID("room-for-improvement-yes");

        // System.out.println(getTextById("room-for-improvement-yes"));

        clickbyXpath("(//button[@type='button'])[3]");

        clickbyXpath("//input[@id='did-not-understand']");

        clickbyXpath("//button[@type='submit']");

        String verify_Message = getTextByXpath("//*[@id=\"details-feedback-wrapper\"]/div/p");

        System.out.println(verify_Message);

        Assert.assertEquals(verify_Message, "Thank you for your feedback");

        quitBrowser();

    }}
