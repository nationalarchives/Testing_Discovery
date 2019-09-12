package ViewMoreCollections;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class OnlineCollections extends Wrapper_methods {

    @Test

    public void OnlineCollections() throws IOException, InterruptedException{

        launchDriver("https://test.discovery.nationalarchives.gov.uk/","chrome");
        ((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
       // click on view more collections
        driver.findElementByXPath("//*[@id=\"more\"]/a").click();
        //verify the message
        String actual = driver.findElementByXPath("//*[@id=\"guide-form\"]/div[1]/p").getText();
        System.out.println(actual);
        Assert.assertEquals("Over 5% of The National Archives' records have so far been digitised and we are continuing to put records online. Browse this section to find out how to search some of our most popular online collections.", actual);
        //getTextByXpath("//*[@id=\"guide-form\"]/h2")
        driver.close();



    }





}
