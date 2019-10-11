package ResearchGuide_MilitaryHonours_Awards;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class MilitaryHonours_Awards_NoInput extends Wrapper_methods {
    @Test
    public void MilitaryHonours_Awards_NoInput() throws IOException, InterruptedException{
        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/recommendations-military-honours-awards-1935-1990/","chrome");
        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // click on search without entering anything
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");
        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // check for WO 373 filter
        String actual = driver.findElementByXPath("//*[@id=\"search-refine\"]/ul/li[2]/span").getText();
        Assert.assertTrue(actual.contains("WO 373"));

        ((JavascriptExecutor) driver).executeScript("scroll(0,1500)");

        // check the fifth record contains WO 373
        String actual1 = driver.findElementByXPath("//*[@id=\"search-results\"]/li[5]/a").getText();
        Assert.assertTrue(actual1.contains("WO 373"));
        driver.quit();
    }
}
