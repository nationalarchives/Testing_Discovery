package ResearchGuide_RoyalNavyServiceRecords;

import com.microsoft.schemas.vml.STExt;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class RoyalNavyServiceRecords_InputYears extends Wrapper_methods {
    @Test(priority = 1)
    public void RoyalNavyServiceRecords_InputYears_OutOfRange() throws IOException, InterruptedException {
        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/royal-navy-ratings-service-records-1853-1928/", "chrome");

        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // enter from date
        clickbyXpath("//*[@id=\"fromDate\"]");
        driver.findElementByXPath("//*[@id=\"fromDate\"]").sendKeys("1800");

        // enter to date
        clickbyXpath("//*[@id=\"toDate\"]");
        driver.findElementByXPath("//*[@id=\"toDate\"]").sendKeys("1810");

        // click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");

        // check for the error message
        String errormessage = driver.findElementByXPath("//*[@id=\"search-results\"]/div/h2").getText();
        System.out.println(errormessage);
        Assert.assertTrue(errormessage.contains("We did not find any results for your search"));
        driver.quit();
    }

    @Test(priority = 2)
    public void RoyalNavyServiceRecords_InputYears_InRange() throws IOException, InterruptedException {
        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/royal-navy-ratings-service-records-1853-1928/", "chrome");

        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // enter from date
        clickbyXpath("//*[@id=\"fromDate\"]");
        driver.findElementByXPath("//*[@id=\"fromDate\"]").sendKeys("1860");

        // enter to date
        clickbyXpath("//*[@id=\"toDate\"]");
        driver.findElementByXPath("//*[@id=\"toDate\"]").sendKeys("1900");

        // click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");

        // check the filter is selected or not
        String checkFilter = driver.findElementByXPath("//*[@id=\"search-refine\"]/ul/li[1]/span").getText();
        System.out.println(checkFilter);
        Assert.assertTrue(checkFilter.contains("1860 - 1900"));
        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // check the third record date is in the range or not
        String StrYear = driver.findElementByXPath("//*[@id=\"search-results\"]/li[3]/a/table/tbody/tr[2]/td[2]/span").getText();
        System.out.println(StrYear);

        int StartYearFromRecord = Integer.parseInt(StrYear.substring(0, 4));
        int EndYearFromRecord = Integer.parseInt(StrYear.substring(7));
        Assert.assertTrue((StartYearFromRecord >= 1860 && StartYearFromRecord <= 1900) ||
                (EndYearFromRecord >= 1860 && EndYearFromRecord <= 1900));

     /*   if ((StartYearFromFilter <= StartYearFromRecord && StartYearFromRecord <= EndYearFromFilter) ||
                (StartYearFromFilter <= EndYearFromRecord && EndYearFromRecord <= EndYearFromFilter)) {
            System.out.println("Success");
        }*/
        /*
        for (int i = StartYearFromFilter;i <= EndYearFromFilter; i++)
        {
            System.out.println(i);
        }
        */
    }

    @Test(priority = 3)
    public void RoyalNavyServiceRecords_AnotherInputYears_InRange() throws IOException, InterruptedException {
        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/royal-navy-ratings-service-records-1853-1928/", "chrome");

        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // enter from date
        clickbyXpath("//*[@id=\"fromDate\"]");
        driver.findElementByXPath("//*[@id=\"fromDate\"]").sendKeys("1900");

        // enter to date
        clickbyXpath("//*[@id=\"toDate\"]");
        driver.findElementByXPath("//*[@id=\"toDate\"]").sendKeys("1910");

        // click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");

        // check the filter is selected or not
        String checkFilter = driver.findElementByXPath("//*[@id=\"search-refine\"]/ul/li[1]/span").getText();
        System.out.println(checkFilter);
        Assert.assertTrue(checkFilter.contains("1900 - 1910"));

        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // check the third record date is in the range or not
        String StrYear = driver.findElementByXPath("//*[@id=\"search-results\"]/li[3]/a/table/tbody/tr[2]/td[2]/span").getText();
        System.out.println(StrYear);

        int StartYearFromRecord = Integer.parseInt(StrYear.substring(0, 4));
       // int EndYearFromRecord = Integer.parseInt(StrYear.substring(7));

        Assert.assertTrue((StartYearFromRecord >= 1900 && StartYearFromRecord <= 1910));

        driver.quit();
    }
}
