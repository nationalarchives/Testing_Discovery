package Redirect_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class Redirect_A2A extends Wrapper_methods {
    @Test
    public void Redirect_A2A() throws IOException, InterruptedException{
        launchDriver("http://www.nationalarchives.gov.uk/a2a/records.aspx?cat=109-mss_1-2_3&cid=2-7","chrome");

        String Title =  driver.findElementByXPath("//*[@id=\"page_wrap\"]/main/div/div/h1").getText();
        System.out.println(Title);
        Assert.assertTrue(Title.contains("Catalogue description"));
        driver.quit();

    }
}
