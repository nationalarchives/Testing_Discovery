package WhatToExpectGuide;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class LetUsKnow_AccessConditions_Information extends Wrapper_methods {
    @Test(priority = 1)
    public void LetUsKnow_AccessConditions_Information_1() throws IOException,InterruptedException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/details/r/C14016701","chrome");
        // click on let us know link
        clickbyXpath("//*[@id=\"show-suggestion-form\"]");
        ((JavascriptExecutor) driver).executeScript("scroll(0,800)");
        // Select access conditions from the dropdown
        Select sortedBy = new Select(driver.findElementById("fieldContainingError"));
        sortedBy.selectByIndex(1);
        Thread.sleep(3000);
        enterTextById("whatIsTheError", "Testing for something");

        ((JavascriptExecutor) driver).executeScript("scroll(0,1200)");
        // click on submit button
        clickbyXpath("//*[@id=\"suggest-a-correction-form\"]/div/fieldset/div[2]/div[3]/input");
       //verify error message
        String actual1=driver.findElementByXPath("//*[@id=\"whatIsTheRecommendation-error\"]").getText();
        System.out.println(actual1);
        Assert.assertEquals("This field is required",actual1);
        driver.close();

    }
    @Test(priority = 2)
    public void LetUsKnow_AccessConditions_Information_2() throws IOException,InterruptedException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/details/r/C14016701","chrome");
        // click on let us know link
        clickbyXpath("//*[@id=\"show-suggestion-form\"]");
        ((JavascriptExecutor) driver).executeScript("scroll(0,800)");
        // Select access conditions from the dropdown
        Select sortedBy = new Select(driver.findElementById("fieldContainingError"));
        sortedBy.selectByIndex(1);
        Thread.sleep(3000);
        // enter data in correct information field
        enterTextById("whatIsTheRecommendation","Testing for something");
        ((JavascriptExecutor) driver).executeScript("scroll(0,1200)");
        // click submit
        clickbyXpath("//*[@id=\"suggest-a-correction-form\"]/div/fieldset/div[2]/div[3]/input");
        // verify error message
        String actual=driver.findElementByXPath("//*[@id=\"whatIsTheError-error\"]").getText();
        System.out.println(actual);
        Assert.assertEquals("This field is required",actual);
        driver.close();

    }
}
