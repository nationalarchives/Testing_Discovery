package ResearchGuide_Wills;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class Wills_SearchRecordsForm_NoInput extends Wrapper_methods {
    @Test
    public void Wills_SearchRecordsForm_NoInput() throws IOException, InterruptedException{
        PopularCollectionsURL();
        // click on Wills link in Popular collections
        clickbyXpath("//*[@id=\"wills\"]/a");
        Thread.sleep(2000);
        // click on the second record
        clickbyXpath("//*[@id=\"reload-marker\"]/div[2]/div/ul/li[2]/a/div");
        ((JavascriptExecutor)driver).executeScript("scroll(0,900)");
        // click on search without entering anything
        clickbyXpath("//*[@id=\"page_wrap\"]/div[2]/div[1]/div[2]/div/form/div/input");
        ((JavascriptExecutor)driver).executeScript("scroll(0,700)");
        // checking the second record, if it contains 'Will'
        String KeywordWill = driver.findElementByXPath("//*[@id=\"search-results\"]/li[2]/a").getText();
        System.out.println(KeywordWill);
        Assert.assertTrue(KeywordWill.contains("Will"));
        driver.quit();
    }
    @Test(priority = 2)
    public void Wills_SearchRecordsForm_NoInput_Results_AnotherField() throws IOException,InterruptedException{
        PopularCollectionsURL();
        // click on Wills link in Popular collections
        clickbyXpath("//*[@id=\"wills\"]/a");
        Thread.sleep(2000);
        // click on the fourth record
        clickbyXpath("//*[@id=\"reload-marker\"]/div[2]/div/ul/li[2]/a/div");
        ((JavascriptExecutor)driver).executeScript("scroll(0,900)");
        // click on search without entering anything
        clickbyXpath("//*[@id=\"page_wrap\"]/div[2]/div[1]/div[2]/div/form/div/input");
        ((JavascriptExecutor)driver).executeScript("scroll(0,700)");
        // checking the fourth record, if it contains 'Will'
        String KeywordWill = driver.findElementByXPath("//*[@id=\"search-results\"]/li[4]/a").getText();
        System.out.println(KeywordWill);
        Assert.assertTrue(KeywordWill.contains("Will"));
        driver.quit();
    }
}
