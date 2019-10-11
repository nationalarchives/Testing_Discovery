package ResearchGuide_RoyalNavyServiceRecords;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class RoyalNavyServiceRecords_InputName extends Wrapper_methods {
    @Test(priority = 1)
    public void RoyalNavyServiceRecords_InputName1() throws IOException, InterruptedException{

        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/royal-navy-ratings-service-records-1853-1928/","chrome");

        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // enter first name and second name
        clickbyXpath("//*[@id=\"firstname\"]");
        driver.findElementByXPath("//*[@id=\"firstname\"]").sendKeys("William");

        clickbyXpath("//*[@id=\"lastname\"]");
        driver.findElementByXPath("//*[@id=\"lastname\"]").sendKeys("shakespeare");

        // click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");

        // check title contains name
        String title = driver.findElementByXPath("//*[@id=\"page_wrap\"]/section[2]/div/div/h1").getText();
        System.out.println(title);
        Assert.assertTrue(title.contains("William shakespeare"));

        ((JavascriptExecutor) driver).executeScript("scroll(0,1100)");

        //check fourth record contains name
        String RecordInfo = driver.findElementByXPath("//*[@id=\"search-results\"]/li[4]/a").getText();

        Assert.assertTrue((RecordInfo.contains("Shakespeare"))&&(RecordInfo.contains("William")) );
        driver.quit();
    }
    @Test(priority = 2)
    public void RoyalNavyServiceRecords_InputAnotherName() throws IOException, InterruptedException{

        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/royal-navy-ratings-service-records-1853-1928/","chrome");

        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // enter first name and second name
        clickbyXpath("//*[@id=\"firstname\"]");
        driver.findElementByXPath("//*[@id=\"firstname\"]").sendKeys("Frederick");

        clickbyXpath("//*[@id=\"lastname\"]");
        driver.findElementByXPath("//*[@id=\"lastname\"]").sendKeys("Arthur");

        // click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");

        // check title contains name
        String title = driver.findElementByXPath("//*[@id=\"page_wrap\"]/section[2]/div/div/h1").getText();
        System.out.println(title);
        Assert.assertTrue(title.contains("Frederick Arthur"));

        ((JavascriptExecutor) driver).executeScript("scroll(0,1100)");

        //check fourth record contains name
        String RecordInfo = driver.findElementByXPath("//*[@id=\"search-results\"]/li[4]/a").getText();

        Assert.assertTrue((RecordInfo.contains("Frederick"))&&(RecordInfo.contains("Arthur")) );
        driver.quit();
    }

}
