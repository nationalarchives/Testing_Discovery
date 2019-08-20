package DetailPageOnTest;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import wrappers.Wrapper_methods;

public class DetailPage_CouldThisPageBeImproved_NO extends Wrapper_methods {

    @Test

    public void DetailPage_CouldThisPageBeImproved_NO() throws IOException, InterruptedException {

        launchDriver("http://test.discovery.nationalarchives.gov.uk/details/r/D32670", "chrome");

        ((JavascriptExecutor) driver).executeScript("scroll(0,500)");

        // click no option on could this page be improved?

        //clickbyID("room-for-improvement-no");

        clickbyXpath("(//button[@type='button'])[2]");

        System.out.println(getTextById("comment_for_satisfaction"));


        String verify_Message = getTextByXpath("//textarea[@id='comment_for_satisfaction']");

        driver.findElementByXPath("//*[@id=\"no_fieldset\"]/button[1]").click();

        System.out.println(verify_Message);
        String verify_Title = getTextByXpath("//*[@id=\"details-feedback-wrapper\"]/div/p");
		System.out.println(verify_Title);
		Thread.sleep(1000);
		Assert.assertEquals(verify_Title, "Thank you for your feedback");

        quitBrowser();

    }

}
