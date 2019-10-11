package ResearchGuide_MilitaryHonours_Awards;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class MilitaryHonours_Awards_Name_rank_years extends Wrapper_methods {
    @Test
    public void MilitaryHonours_Awards_Name_rank_years() throws IOException, InterruptedException {

        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/recommendations-military-honours-awards-1935-1990/","chrome");
        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // enter first name
        clickbyXpath("//*[@id=\"firstname\"]");
        driver.findElementByXPath("//*[@id=\"firstname\"]").sendKeys("John");


        // enter last name
        clickbyXpath("//*[@id=\"lastname\"]");
        driver.findElementByXPath("//*[@id=\"lastname\"]").sendKeys("Leng");

        // enter from year
        clickbyXpath("//*[@id=\"fromDate\"]");
        driver.findElementByXPath("//*[@id=\"fromDate\"]").sendKeys("1940");

        // enter to year
        clickbyXpath("//*[@id=\"toDate\"]");
        driver.findElementByXPath("//*[@id=\"toDate\"]").sendKeys("1970");

        // click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");

        // check the filter 1940-1970
        String Year = driver.findElementByXPath("//*[@id=\"search-refine\"]/ul/li[1]/span").getText();
        System.out.println(Year);
        Assert.assertTrue(Year.contains("1940 - 1970"));

        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // check for John Leng in Second record
        String ChkName = driver.findElementByXPath("//*[@id=\"search-results\"]/li[2]/a").getText();
        System.out.println(ChkName);
       Assert.assertTrue((ChkName.contains("Leng"))&&(ChkName.contains("John")));
       driver.quit();
    }
}
