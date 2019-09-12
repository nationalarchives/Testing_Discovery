package WhatToExpectGuide;

import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class LetUsKnow_NothingFromTheDropdown_Submit extends Wrapper_methods {
    @Test

    public void LetUsKnow_NothingFromTheDropdown_Submit() throws IOException, InterruptedException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/details/r/C14016701","chrome");
        // click on let us know link
        clickbyXpath("//*[@id=\"show-suggestion-form\"]");
        // click on submit button
        clickbyXpath("//*[@id=\"suggest-a-correction-form\"]/div/fieldset/div[2]/div[3]/input");
        //Verify 3 error messages
        String actual1=driver.findElementByXPath("//*[@id=\"fieldContainingError-error\"]").getText();
        System.out.println(actual1);
        Assert.assertEquals("This field is required",actual1);

        String actual2=driver.findElementByXPath("//*[@id=\"whatIsTheError-error\"]").getText();
        System.out.println(actual2);
        Assert.assertEquals("This field is required",actual2);

        String actual3=driver.findElementByXPath("//*[@id=\"whatIsTheError-error\"]").getText();
        System.out.println(actual3);
        Assert.assertEquals("This field is required",actual3);
        driver.close();

    }


}
