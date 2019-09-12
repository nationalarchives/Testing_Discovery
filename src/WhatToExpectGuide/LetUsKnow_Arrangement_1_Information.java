package WhatToExpectGuide;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class LetUsKnow_Arrangement_1_Information extends Wrapper_methods {
    @Test
    public void LetUsKnow_Arrangement_1_Information() throws IOException, InterruptedException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/details/r/C14016701","chrome");
        // click on let us know link
        clickbyXpath("//*[@id=\"show-suggestion-form\"]");
        ((JavascriptExecutor) driver).executeScript("scroll(0,800)");
        // Select access conditions from the dropdown
        Select sortedby = new Select(driver.findElementByXPath("//*[@id=\"fieldContainingError\"]"));
        sortedby.selectByIndex(2);
        enterByTextXpath("//*[@id=\"whatIsTheRecommendation\"]","Testing for something");
        //click submit
        clickbyXpath("//*[@id=\"suggest-a-correction-form\"]/div/fieldset/div[2]/div[3]/input");
        // verify the error
        String actual = driver.findElementByXPath("//*[@id=\"whatIsTheError-error\"]").getText();
        System.out.println(actual);
        Assert.assertEquals("This field is required",actual);
        driver.close();

    }
}


