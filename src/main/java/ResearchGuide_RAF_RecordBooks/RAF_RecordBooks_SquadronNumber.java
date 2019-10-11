package ResearchGuide_RAF_RecordBooks;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class RAF_RecordBooks_SquadronNumber extends Wrapper_methods {
    @Test(priority = 1)
    public void RAF_RecordBooks_SquadronNumber() throws IOException, InterruptedException{

        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/raf-operations-record-books-1939-1945/","chrome");

        ((JavascriptExecutor) driver).executeScript("scroll(0,1200)");

        // enter Squadron number
        clickbyXpath("//*[@id=\"squadronnumber\"]");
        driver.findElementByXPath("//*[@id=\"squadronnumber\"]").sendKeys("67");

        // click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");

        String title = driver.findElementByXPath("//*[@id=\"search-results\"]/li[1]/a").getText();
        Assert.assertTrue(title.contains("67"));
        driver.quit();
    }
    @Test(priority = 2)
    public void RAF_RecordBooks_AnotherSquadronNumber() throws IOException, InterruptedException{

        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/raf-operations-record-books-1939-1945/","chrome");

        ((JavascriptExecutor) driver).executeScript("scroll(0,1200)");

        // enter Squadron number
        clickbyXpath("//*[@id=\"squadronnumber\"]");
        driver.findElementByXPath("//*[@id=\"squadronnumber\"]").sendKeys("100");

        // click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");

        String title = driver.findElementByXPath("//*[@id=\"search-results\"]/li[1]/a").getText();
        Assert.assertTrue(title.contains("100"));
        driver.quit();
    }

}
