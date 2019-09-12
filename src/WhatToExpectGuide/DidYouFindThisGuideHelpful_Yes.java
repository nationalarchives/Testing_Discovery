package WhatToExpectGuide;

import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class DidYouFindThisGuideHelpful_Yes extends Wrapper_methods {
    @Test(priority = 1)

    public void DidYouFindThisGuideHelpful_Yes() throws IOException, InterruptedException{
         launchDriver("https://test.discovery.nationalarchives.gov.uk/details/r/C14016699","chrome");
        // click on yes
         clickbyXpath("//*[@id=\"what-to-expect-form\"]/div/form/fieldset/button[1]");
         // testing for We'd like to hear from you
        String actual1=driver.findElementByXPath("//*[@id=\"no_fieldset\"]/legend").getText();
        System.out.println(actual1);
        Assert.assertEquals("We'd like to hear from you",actual1);
        // testing for Your feedback helps us improve our services. Please share any comments below (optional).
        String actual2 = driver.findElementByXPath("//*[@id=\"no_fieldset\"]/div/label").getText();
        System.out.println(actual2);
        Assert.assertEquals("Your feedback helps us improve our services. Please share any comments below (optional).",actual2);

    }

    @Test(priority = 2)

    public void DidYouFindThisGuideHelpful_Yes_EnterText() throws IOException,InterruptedException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/details/r/C14016699","chrome");
        // click on yes
        clickbyXpath("//*[@id=\"what-to-expect-form\"]/div/form/fieldset/button[1]");
        // enter testing for something
        clickbyXpath("//*[@id=\"comments\"]");
        driver.findElementByXPath("//*[@id=\"comments\"]").sendKeys("Testing we'd like to hear from you form with different fields");
        // click on send
        clickbyXpath("//*[@id=\"no_fieldset\"]/button[1]");
        // testing for thank you for your feedback
        String Feedback = driver.findElementByXPath("//*[@id=\"what-to-expect-form\"]/div/p").getText();
        System.out.println(Feedback);
        Assert.assertEquals("Thank you for your feedback", Feedback);
    }
    @Test(priority = 3)
    public void DidYouFindThisGuideHelpful_Yes_WithoutText() throws InterruptedException, IOException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/details/r/C14016699","chrome");
        // click on yes
        clickbyXpath("//*[@id=\"what-to-expect-form\"]/div/form/fieldset/button[1]");
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
