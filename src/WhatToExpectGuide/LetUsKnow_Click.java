package WhatToExpectGuide;

import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class LetUsKnow_Click extends Wrapper_methods {
    @Test
    public void LetUsKnow_Click() throws IOException,InterruptedException{
        launchDriver("https://test.discovery.nationalarchives.gov.uk/details/r/C14016701","chrome");
        // click on let us know link
        clickbyXpath("//*[@id=\"show-suggestion-form\"]");
       // verify the title 'which field contains error'
        String actual=driver.findElementByXPath("//*[@id=\"suggest-a-correction-form\"]/div/fieldset/div[1]/div[1]/label").getText();
        System.out.println(actual);
        Assert.assertEquals("Which field contains the error?", actual);
        driver.close();
    }
}
