package WhatToExpectGuide;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class ReadMore_ReadLess extends Wrapper_methods {
    @Test(priority = 1)
    public void ReadMore_ReadLess() throws IOException,InterruptedException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/details/r/C14016699","chrome");
        ((JavascriptExecutor)driver).executeScript("scroll(0,600)");
        // click on read more
        clickbyXpath("//*[@id=\"expand-supplemental\"]");
        ((JavascriptExecutor)driver).executeScript("scroll(0,800)");
        // check for the title 'What information do the records contain?'
        String actual1 = driver.findElementByXPath("//*[@id=\"supplemental\"]/h3[1]").getText();
        System.out.println(actual1);
        Assert.assertEquals("What information do the records contain?", actual1);
       // click on read less
       clickbyXpath("//button[@id='expand-supplemental']");
     // clickbyXpath("/html/body/div[2]/main/div/div/div/div[2]/div/button");
       //driver.findElementByXPath("//button[@id='expand-supplemental']").click();

       // check for 'read more' button
       // String actual2 = driver.findElementByXPath("//*[@id=\"expand-supplemental\"]").getText();
        //System.out.println(actual2);
        //Assert.assertEquals("Read more",actual2);
    }
    @Test(priority = 2)
    public void ReadMore_ReadLess_researchGuide() throws IOException,InterruptedException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/details/r/C14016699","chrome");
        ((JavascriptExecutor)driver).executeScript("scroll(0,600)");
        // click on read more
        clickbyXpath("//*[@id=\"expand-supplemental\"]");
        ((JavascriptExecutor)driver).executeScript("scroll(0,800)");
        // click on research guide
       clickbyXpath("//div[@id='supplemental']/p[5]/a");

    }
    @Test (priority = 3)
    public void ReadMore_ReadLess_pagination() throws IOException,InterruptedException{
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
        // click on read more
        clickbyXpath("//*[@id=\"expand-supplemental\"]");
        ((JavascriptExecutor)driver).executeScript("scroll(0,800)");
        // check for the title 'What information do the records contain?'
        String actual1 = driver.findElementByXPath("//*[@id=\"supplemental\"]/h3[1]").getText();
        System.out.println(actual1);
        Assert.assertEquals("What information do the records contain?", actual1);
        // click on read less
        clickbyXpath("//div[2]/div/button");
    }
}
