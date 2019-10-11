package SearchUI_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class Tests_AdvancedSearch_Browse extends Wrapper_methods {
    @Test(priority=1)
    public void Test_AdvancedSearch() throws IOException, InterruptedException{
        SearchUIURL();
        // click on advanced search
        clickbyXpath("//*[@id=\"discovery-home-page-search\"]/div/div[6]/a[1]");

        // check for the title on the page
        String actual = driver.findElementByXPath("//*[@id=\"page_wrap\"]/div[2]/div[1]/h1/span/span").getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains("Advanced search"));
        driver.quit();
    }
    @Test(priority=2)
    public void Browse() throws IOException, InterruptedException{
        SearchUIURL();
        // click on advanced search
        clickbyXpath("//*[@id=\"discovery-home-page-search\"]/div/div[6]/a[2]");

        // check for the title on the page
        String actual = driver.findElementByXPath("//*[@id=\"page_wrap\"]/section[2]/div/div[1]/h1/span/span").getText();
        System.out.println(actual);
        Assert.assertTrue(actual.contains("Browse records"));
        driver.quit();
    }
}
