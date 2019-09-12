package WhatToExpectGuide;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class LetUsKnow_AccessConditions_AllFields extends Wrapper_methods {
    @Test

    public void LetUsKnow_AccessConditions_AllFields() throws IOException,InterruptedException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/details/r/C14016701","chrome");
        // click on let us know link
        clickbyXpath("//*[@id=\"show-suggestion-form\"]");
        ((JavascriptExecutor) driver).executeScript("scroll(0,800)");
        // Select access conditions from the dropdown
        Select sortedBy = new Select(driver.findElementById("fieldContainingError"));
        sortedBy.selectByIndex(1);
        Thread.sleep(3000);
        //enter information
        enterTextById("whatIsTheError", "Testing for something");
        enterTextById("whatIsTheRecommendation", "Testing for something");
        enterTextById("referenceDetails", "Testing for something");
        ((JavascriptExecutor) driver).executeScript("scroll(0,1200)");
        //enter name and email address
        enterTextById("userName","Tester");
        enterTextById("userEmail","tnadiscovery100@gmail.com");
        // click on submit
        clickbyXpath("//*[@id=\"suggest-a-correction-form\"]/div/fieldset/div[2]/div[3]/input");
        driver.close();

    }
}
