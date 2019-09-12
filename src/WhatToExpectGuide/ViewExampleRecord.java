package WhatToExpectGuide;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class ViewExampleRecord extends Wrapper_methods {
    @Test(priority = 1)
    public void ViewExampleRecord() throws IOException, InterruptedException {
        launchDriver("https://test.discovery.nationalarchives.gov.uk/details/r/C14016702","chrome");
        ((JavascriptExecutor)driver).executeScript("scroll(0,600)");
        // click on 'view a page from an example war diary'
        clickbyXpath("//*[@id=\"wteg-image-wrapper\"]/div/span");
        // check for the title 'example record only'
        String imagetitle = driver.findElementByXPath("//*[@id=\"tnaModalComponent\"]/div/div[2]/div/figure/figcaption").getText();
        System.out.println(imagetitle);
        Assert.assertEquals("Example record only", imagetitle);
    }
    @Test(priority = 2)
    public void ViewExampleRecord_pagination() throws IOException,InterruptedException{
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
        ((JavascriptExecutor)driver).executeScript("scroll(0,800)");
        // click on 'view a page from an example war diary'
        clickbyXpath("//*[@id=\"wteg-image-wrapper\"]/div/span");
        // check for the title 'example record only'
        String imagetitle = driver.findElementByXPath("//*[@id=\"tnaModalComponent\"]/div/div[2]/div/figure/figcaption").getText();
        System.out.println(imagetitle);
        Assert.assertEquals("Example record only", imagetitle);

    }
}
