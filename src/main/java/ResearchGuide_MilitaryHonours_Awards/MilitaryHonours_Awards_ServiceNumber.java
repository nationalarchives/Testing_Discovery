package ResearchGuide_MilitaryHonours_Awards;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class MilitaryHonours_Awards_ServiceNumber extends Wrapper_methods {
    @Test
    public void MilitaryHonours_Awards_ServiceNumber() throws IOException, InterruptedException {

        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/recommendations-military-honours-awards-1935-1990/", "chrome");
        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // enter service number
        clickbyXpath("//*[@id=\"servicenumber\"]");
        driver.findElementByXPath("//*[@id=\"servicenumber\"]").sendKeys("74591");

        // click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");
        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // check the third record contains '74591'
        String ServiceNum = driver.findElementByXPath("//*[@id=\"search-results\"]/li[3]/a").getText();
        System.out.println(ServiceNum);
        Assert.assertTrue(ServiceNum.contains("74591"));
        driver.quit();
    }
}