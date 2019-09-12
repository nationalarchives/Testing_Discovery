package WhatToExpectGuide;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class LetUsKnow_AccessConditions_NoData extends Wrapper_methods {
    @Test
    public void LetUsKnow_AccessConditions_NoData() throws IOException, InterruptedException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/details/r/C14016701","chrome");
        // click on let us know link
        clickbyXpath("//*[@id=\"show-suggestion-form\"]");
        ((JavascriptExecutor) driver).executeScript("scroll(0,800)");
        // Select access conditions from the dropdown
        Select sortedBy = new Select(driver.findElementById("fieldContainingError"));
        sortedBy.selectByIndex(1);
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("scroll(0,1200)");
        // click on submit
        clickbyXpath("//*[@id=\"suggest-a-correction-form\"]/div/fieldset/div[2]/div[3]/input");
        // verify the 2 error messages
        String actual1=driver.findElementByXPath("//*[@id=\"whatIsTheError-error\"]").getText();
        System.out.println(actual1);
        Assert.assertEquals("This field is required", actual1);
        String actual2=driver.findElementByXPath("//*[@id=\"whatIsTheRecommendation-error\"]").getText();
        System.out.println(actual2);
        Assert.assertEquals("This field is required", actual2);
        driver.close();


    }
}
