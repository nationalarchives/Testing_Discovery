package SearchUI_Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class Tests_HeldBy extends Wrapper_methods {
    @Test(priority = 1)
    public void Tests_HeldBy_TNA() throws IOException,InterruptedException{
        SearchUIURL();
        // enter random Navy in search
        driver.findElementByXPath("//*[@id=\"search-for\"]").sendKeys("Navy");

       // check for All archives selected or not
        String Allarchives = driver.findElementByXPath("//*[@id=\"held-by\"]").getText();
        System.out.println(Allarchives);

        // select the national archives only from the dropdown
        Select sortedBy = new Select(driver.findElementByXPath("//*[@id=\"held-by\"]"));
        sortedBy.selectByIndex(1);

        // click on search
        clickbyXpath("//*[@id=\"discovery-home-page-search\"]/div/div[7]/button");

        // check filter
        String chkfilter = driver.findElementByXPath("//*[@id=\"search-refine\"]/ul/li[1]/span").getText();
        System.out.println(chkfilter);
        Assert.assertTrue(chkfilter.contains("The National Archives"));

        ((JavascriptExecutor)driver).executeScript("scroll(0,1500)");

        // check 5th record contains the national archives
        String chkrecord = driver.findElementByXPath("//*[@id=\"search-results\"]/li[5]/a").getText();
        System.out.println(chkrecord);
        Assert.assertTrue(chkrecord.contains("The National Archives"));
        driver.quit();
    }
    @Test(priority = 1)
    public void Tests_HeldBy_OtherArchives() throws IOException,InterruptedException{
        SearchUIURL();
        // enter random army in search
        driver.findElementByXPath("//*[@id=\"search-for\"]").sendKeys("army");

        // check for All archives selected or not
        String Allarchives = driver.findElementByXPath("//*[@id=\"held-by\"]").getText();
        System.out.println(Allarchives);

        // select the national archives only from the dropdown
        Select sortedBy = new Select(driver.findElementByXPath("//*[@id=\"held-by\"]"));
        sortedBy.selectByIndex(2);

        // click on search
        clickbyXpath("//*[@id=\"discovery-home-page-search\"]/div/div[7]/button");

        // check filter
        String chkfilter = driver.findElementByXPath("//*[@id=\"search-refine\"]/ul/li[1]/span").getText();
        System.out.println(chkfilter);
        Assert.assertTrue(chkfilter.contains("Other archives"));
        driver.quit();
    }
}
