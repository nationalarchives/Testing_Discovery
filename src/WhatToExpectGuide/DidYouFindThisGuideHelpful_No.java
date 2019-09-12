package WhatToExpectGuide;

import groovy.json.internal.IO;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;
import java.io.InterruptedIOException;

public class DidYouFindThisGuideHelpful_No extends Wrapper_methods {
    @Test(priority = 1)
    public void DidYouFindThisGuideHelpful_No() throws  IOException, InterruptedException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/details/r/5a488d46a1be4cefacc2d4d2401567e5","chrome");
        // click on no button
        clickbyXpath("//*[@id=\"what-to-expect-form\"]/div/form/fieldset/button[2]");
        // test for the title Please let us know why you are dissatisfied
        String title = driver.findElementByXPath("//*[@id=\"no_fieldset\"]/legend").getText();
        System.out.println(title);
        Assert.assertEquals("Please let us know why you are dissatisfied" , title);

        // test for the title
        String title1 = driver.findElementByXPath("//*[@id=\"no_fieldset\"]/div/label").getText();
        System.out.println(title1);
        Assert.assertEquals("Your feedback helps us improve our services. Please share any comments below.", title1);
    }
    @Test(priority = 2)
    public void DidYouFindThisGuideHelpful_No_EnterText() throws IOException,InterruptedException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/details/r/5a488d46a1be4cefacc2d4d2401567e5","chrome");
        // click on no button
        clickbyXpath("//*[@id=\"what-to-expect-form\"]/div/form/fieldset/button[2]");
        // enter testing for something
        clickbyXpath("//*[@id=\"comments\"]");
        driver.findElementByXPath("//*[@id=\"comments\"]").sendKeys("Testing we'd like to hear from you form with different fields");
        // click on send button
        clickbyXpath("//*[@id=\"no_fieldset\"]/button[1]");
        // testing for thank you for your feedback
        String Feedback = driver.findElementByXPath("//*[@id=\"what-to-expect-form\"]/div/p").getText();
        System.out.println(Feedback);
        Assert.assertEquals("Thank you for your feedback", Feedback);
    }
    @Test(priority = 2)
    public void DidYouFindThisGuideHelpful_No_WithoutText() throws IOException,InterruptedException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/details/r/5a488d46a1be4cefacc2d4d2401567e5","chrome");
        // click on no button
        clickbyXpath("//*[@id=\"what-to-expect-form\"]/div/form/fieldset/button[2]");
        // dont enter anything
        clickbyXpath("//*[@id=\"comments\"]");
        // click on send
        clickbyXpath("//*[@id=\"no_fieldset\"]/button[1]");
        // testing for thank you for your feedback
        String Feedback = driver.findElementByXPath("//*[@id=\"what-to-expect-form\"]/div/p").getText();
        System.out.println(Feedback);
        Assert.assertEquals("Thank you for your feedback", Feedback);

    }
}
