package WhatToExpectGuide;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class DidYouFindThisGuideHelpful_Pagination extends Wrapper_methods {
    @Test(priority = 1)
    public void DidYouFindThisGuideHelpful_Pagination_yes() throws IOException, InterruptedException{

        launchDriver("https://test.discovery.nationalarchives.gov.uk/","chrome");
        driver.findElementByXPath("//*[@id=\"search-all-collections\"]").sendKeys("\"wo 95\"");
       // click on search button
       clickbyXpath("//*[@id=\"main-search-container\"]/input[2]");
       // click on available for download only
        clickbyXpath("//*[@id=\"heldby\"]/div/ul/li[2]/a");
        ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
       // click on Item on the left hand side
       clickbyXpath("//*[@id=\"l_7\"]");
        Thread.sleep(1000);
       // click on Refine
        clickbyXpath("//*[@id=\"catalogue-levels\"]/form/div/input");
        ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
        Thread.sleep(1000);
        // click on the fourth result
        clickbyXpath("//*[@id=\"search-results\"]/li[4]/a/p");
        Thread.sleep(3000);
        ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
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
    @Test(priority = 2)
   public void DidYouFindThisGuideHelpful_Pagination_no() throws IOException, InterruptedException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/","chrome");
        driver.findElementByXPath("//*[@id=\"search-all-collections\"]").sendKeys("\"wo 95\"");
        // click on search button
        clickbyXpath("//*[@id=\"main-search-container\"]/input[2]");
        // click on available for download only
        clickbyXpath("//*[@id=\"heldby\"]/div/ul/li[2]/a");
        ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
        // click on Item on the left hand side
        clickbyXpath("//*[@id=\"l_7\"]");
        Thread.sleep(1000);
        // click on Refine
        clickbyXpath("//*[@id=\"catalogue-levels\"]/form/div/input");
        ((JavascriptExecutor)driver).executeScript("scroll(0,1500)");
        Thread.sleep(1000);
        // click on the seventh result
        clickbyXpath("//*[@id=\"search-results\"]/li[7]/a/p");
        Thread.sleep(3000);
        ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
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

}
