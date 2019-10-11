package Redirect_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class Redirect_NRA extends Wrapper_methods {
    @Test
    public void Redirect_NRA() throws IOException, InterruptedException{

        launchDriver("https://discovery.nationalarchives.gov.uk/redirect/nra?id=O130952","chrome");

        String Title =  driver.findElementByXPath("//*[@id=\"collections\"]/caption").getText();
        System.out.println(Title);
        Assert.assertTrue(Title.contains("Collections"));
        driver.quit();
    }
}
